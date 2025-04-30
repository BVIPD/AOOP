package module3;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class FileServer {
    private static final int PORT = 9000;                  
    private static final int THREAD_POOL_SIZE = 10;      
    private static final String UPLOAD_DIR = "uploads";   
    private static ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public static void main(String[] args) {
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists() && !uploadDir.mkdirs()) {
            System.err.println("Failed to create upload directory: " + UPLOAD_DIR);
            System.exit(1);
        }
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down server...");
            executor.shutdown();
            try {
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
            }
        }));

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getInetAddress());
                executor.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            System.err.println("Server exception: " + e.getMessage());
        }
    }
    static class ClientHandler implements Runnable {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try (DataInputStream dis = new DataInputStream(socket.getInputStream());
                 DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {

                String command = dis.readUTF(); 

                if ("UPLOAD".equalsIgnoreCase(command)) {
                    handleUpload(dis, dos);
                } else if ("DOWNLOAD".equalsIgnoreCase(command)) {
                    handleDownload(dis, dos);
                } else {
                    dos.writeUTF("Invalid Command");
                    System.err.println("Received invalid command from " + socket.getInetAddress());
                }
            } catch (IOException e) {
                System.err.println("Error handling client [" + socket.getInetAddress() + "]: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
        private void handleUpload(DataInputStream dis, DataOutputStream dos) throws IOException {
            String fileName = dis.readUTF();
            long fileSize = dis.readLong();
            File file = new File(UPLOAD_DIR + File.separator + fileName);

            try (FileOutputStream fos = new FileOutputStream(file)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                long remaining = fileSize;
                while (remaining > 0 && (bytesRead = dis.read(buffer, 0, (int) Math.min(buffer.length, remaining))) != -1) {
                    fos.write(buffer, 0, bytesRead);
                    remaining -= bytesRead;
                }
            }

            dos.writeUTF("Upload Successful");
            System.out.println("File \"" + fileName + "\" uploaded successfully from " + socket.getInetAddress());
        }
        private void handleDownload(DataInputStream dis, DataOutputStream dos) throws IOException {
            String fileName = dis.readUTF();
            File file = new File(UPLOAD_DIR + File.separator + fileName);

            if (!file.exists()) {
                dos.writeUTF("File not found");
                System.err.println("File \"" + fileName + "\" not found for " + socket.getInetAddress());
                return;
            } else {
                dos.writeUTF("FOUND");
            }

            long fileSize = file.length();
            dos.writeLong(fileSize);

            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    dos.write(buffer, 0, bytesRead);
                }
                dos.flush();
            }
            System.out.println("File \"" + fileName + "\" downloaded successfully to " + socket.getInetAddress());
        }
    }
}
