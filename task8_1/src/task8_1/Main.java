package task8_1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactManager cm = new ContactManager();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n----- Contact Manager Menu -----");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Delete Contact");
            System.out.println("4. Search Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();
                    cm.addContact(name, phone);
                    break;
                    
                case 2:
                    cm.displayContacts();
                    break;
                    
                case 3:
                    System.out.print("Enter Name to Delete: ");
                    String deleteName = sc.nextLine();
                    cm.deleteContact(deleteName);
                    break;
                    
                case 4:
                    System.out.print("Enter Name to Search: ");
                    String searchName = sc.nextLine();
                    cm.searchContact(searchName);
                    break;
                    
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid Choice! Please Try Again.");
            }
        }
    }
}
