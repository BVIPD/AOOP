package task11_2;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class ProducerConsumerExample {
    private static final BlockingQueue<String> sharedQueue = new LinkedBlockingQueue<>();
    static class Producer implements Runnable {
        private final String producerName;

        public Producer(String name) {
            this.producerName = name;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= 5; i++) {
                    String message = "Message " + i + " from " + producerName;
                    sharedQueue.put(message);
                    Thread.sleep(500);
                }
                sharedQueue.put("DONE");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    static class Consumer implements Runnable {
        private final String consumerName;

        public Consumer(String name) {
            this.consumerName = name;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String message = sharedQueue.take();
                    if (message.equals("DONE")) {
                        break;
                    }
                    System.out.println(consumerName + " received: " + message);
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    public static void main(String[] args) {
        Producer producer1 = new Producer("Producer-1");
        Consumer consumer1 = new Consumer("Consumer-1");
        Thread producerThread1 = new Thread(producer1);
        Thread consumerThread1 = new Thread(consumer1);
        producerThread1.start();
        consumerThread1.start();
        try {
            producerThread1.join();
            consumerThread1.join(2000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Main thread finished.");
    }
}
