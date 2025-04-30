package module2;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RailwayTicketSystem {
    private PriorityQueue<Passenger> queue;

    public RailwayTicketSystem() {
        queue = new PriorityQueue<>();
    }

    public void bookTicket(String name, int age, boolean isVIP) {
        Passenger p = new Passenger(name, age, isVIP);
        queue.offer(p);
        System.out.println(name + " added to the booking queue.");
    }

    public void processBooking() {
        if (queue.isEmpty()) {
            System.out.println("No passengers in the queue.");
            return;
        }
        Passenger p = queue.poll();
        System.out.println("Ticket booked for: " + p);
    }

    public void startBookingSystem() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Book Ticket\n2. Process Booking\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Passenger Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    
                    System.out.print("Is VIP? (true/false): ");
                    boolean isVIP = scanner.nextBoolean();

                    bookTicket(name, age, isVIP);
                    break;

                case 2:
                    processBooking();
                    break;

                case 3:
                    System.out.println("Exiting... All pending bookings will be processed.");
                    while (!queue.isEmpty()) {
                        processBooking();
                    }
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        }
    }

    public static void main(String[] args) {
        RailwayTicketSystem system = new RailwayTicketSystem();
        system.startBookingSystem();
    }
}
