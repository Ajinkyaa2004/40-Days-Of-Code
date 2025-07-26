// Problem 10: Simple Key-Value Store (Collections - HashMap)
// Goal: Learn to use HashMap for storing key-value pairs.
// Tasks:
// Create a class ContactBook.
// In the main method:
// Create a HashMap where keys are String (contact names) and values are String (phone numbers): HashMap<String, String> contacts = new HashMap<>();.
// Add Contacts: Add at least 3 name-phone number pairs to the map.
// Get Phone Number: Get and print the phone number for a specific contact name.
// Check If Exists: Check if a specific contact name exists in the map and print the result.
// Update Phone Number: Update the phone number for an existing contact.
// Remove Contact: Remove a contact from the map.
// Iterate and Print: Iterate through all key-value pairs in the map and print each one. (Hint: use entrySet() or keySet() and get()).
// Concepts Covered: HashMap, Generics (<String, String>), put(), get(), containsKey(), remove(), Iterating over HashMap (basic).


import java.util.HashMap;
import java.util.Map;

public class ContactBook {
    public static void main(String[] args) {

        HashMap<String, String> contacts = new HashMap<>();


        contacts.put("Alice", "9876543210");
        contacts.put("Bob", "9123456780");
        contacts.put("Charlie", "9012345678");


        String name = "Alice";
        System.out.println("Phone number of " + name + ": " + contacts.get(name));

  
        String checkName = "Bob";
        System.out.println("Does " + checkName + " exist? " + contacts.containsKey(checkName));


        contacts.put("Charlie", "9999999999");
        System.out.println("Updated Charlie's number: " + contacts.get("Charlie"));


        contacts.remove("Bob");
        System.out.println("After removing Bob: " + contacts);


        System.out.println("\nAll contacts:");
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
