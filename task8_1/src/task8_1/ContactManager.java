package task8_1;

import java.util.HashMap;
import java.util.Map;

public class ContactManager {
    private Map<String, String> contacts;
    public ContactManager() {
        contacts = new HashMap<>();
    }
    public void addContact(String name, String phoneNumber) {
        contacts.put(name, phoneNumber);
        System.out.println("Contact added: " + name);
    }
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("Contact List:");
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
    public void deleteContact(String name) {
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Contact deleted: " + name);
        } else {
            System.out.println("Contact not found.");
        }
    }
    public void searchContact(String name) {
        if (contacts.containsKey(name)) {
            System.out.println(name + ": " + contacts.get(name));
        } else {
            System.out.println("Contact not found.");
        }
    }
}
