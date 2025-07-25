// Problem 9: Basic List Operations (Collections - ArrayList)
// Goal: Understand how to use ArrayList for dynamic lists.
// Tasks:
// Create a class GroceryList.
// In the main method:
// Create an ArrayList of String to store grocery items: ArrayList<String> groceryItems = new ArrayList<>();.
// Add Items: Add at least 5 grocery items to the list.
// Print All: Print all items in the list.
// Remove Item: Remove one item from the list by its name or index.
// Check Contains: Check if a specific item exists in the list and print the result.
// Get Item: Get and print the item at a specific index.
// Update Item: Change an item at a specific index to a new value.
// Size: Print the current size of the list.
// Concepts Covered: ArrayList, Generics (<String>), add(), remove(), contains(), get(), set(), size().



import java.util.ArrayList;

public class GroceryList {
    public static void main(String[] args) {
        ArrayList<String> groceryItems = new ArrayList<>();

        groceryItems.add("Milk");
        groceryItems.add("Bread");
        groceryItems.add("Eggs");
        groceryItems.add("Apples");
        groceryItems.add("Rice");
     
        System.out.println("Grocery List: " + groceryItems);

        groceryItems.remove("Bread");
        System.out.println("After removing 'Bread': " + groceryItems);

        String itemToCheck = "Eggs";

        System.out.println("Contains '" + itemToCheck + "': " + groceryItems.contains(itemToCheck));
        System.out.println("Item at index 2: " + groceryItems.get(2));

        groceryItems.set(1, "Bananas");

        System.out.println("After updating index 1 to 'Bananas': " + groceryItems);
        System.out.println("Total items: " + groceryItems.size());
    }
}
