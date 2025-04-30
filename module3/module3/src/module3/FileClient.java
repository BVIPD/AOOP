package module3;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class FileClient {
    private static final String SERVER_IP = "localhost"; 
    private static final int SERVER_PORT = 9000;         
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:\n1. Upload File\n2. Download File");
        int option = scanner.nextInt();
        scanner.nextLine(); 
        if (option == 1) {
            System.out.print("Enter the full file path to upload: ");
            String filePath = scanner.nextLine();
            uploadFile(filePath);
        } else if (option == 2) {
            System.out.print("Enter the file name to download (as stored on server): ");
            String fileName = scanner.nextLine();
            downloadFile(fileName);
        } else {
            System.out.println("Invalid Option");
        }
        scanner.close();
    }
    private static void uploadFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("File does not exist: " + filePath);
            return;
        }
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
             DataInputStream dis = new DataInputStream(socket.getInputStream());
             FileInputStream fis = new FileInputStream(file)) {
            dos.writeUTF("UPLOAD");
            dos.writeUTF(file.getName());
            dos.writeLong(file.length());
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                dos.write(buffer, 0, bytesRead);
            }
            dos.flush();
            String response = dis.readUTF();
            System.out.println("Server response: " + response);

        } catch (IOException e) {
            System.err.println("Upload error: " + e.getMessage());
        }
    }
    private static void downloadFile(String fileName) {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
             DataInputStream dis = new DataInputStream(socket.getInputStream())) {
            dos.writeUTF("DOWNLOAD");
            dos.writeUTF(fileName);
            String serverResponse = dis.readUTF();
            if ("File not found".equalsIgnoreCase(serverResponse)) {
                System.err.println("File not found on server: " + fileName);
                return;
            }
            long fileSize = dis.readLong();
            File outFile = new File("downloaded_" + fileName);
            try (FileOutputStream fos = new FileOutputStream(outFile)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                long remaining = fileSize;
                while (remaining > 0 && (bytesRead = dis.read(buffer, 0, (int) Math.min(buffer.length, remaining))) != -1) {
                    fos.write(buffer, 0, bytesRead);
                    remaining -= bytesRead;
                }
                fos.flush();
            }
            System.out.println("File downloaded successfully as: " + outFile.getName());

        } catch (IOException e) {
            System.err.println("Download error: " + e.getMessage());
        }
    }
}
