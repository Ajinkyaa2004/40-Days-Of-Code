// Problem 8: Simple Exception Handling (Exception Handling)
// Goal: Practice try-catch blocks for handling runtime exceptions.
// Tasks:
// Create a class ExceptionHandlingDemo.
// Divide by Zero:
// In the main method, ask the user to input two numbers (you can hardcode them for simplicity initially).
// Perform division: result = num1 / num2;.
// Wrap this division in a try-catch block to catch ArithmeticException (for division by zero).
// In the catch block, print an informative error message: "Cannot divide by zero!"
// Array Index Out of Bounds:
// Create an integer array of size 5.
// Attempt to access an element at index 10 (which is out of bounds).
// Wrap this access in another try-catch block to catch ArrayIndexOutOfBoundsException.
// In the catch block, print an informative error message.
// Finally Block: Add a finally block to one of your try-catch structures and print a message like "This code always executes."
// Concepts Covered: try-catch-finally, ArithmeticException, ArrayIndexOutOfBoundsException, basic error messages.

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;


        try {
            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        } finally {
            System.out.println("This code always executes.");
        }


        int[] numbers = {1, 2, 3, 4, 5};

        try {
            int value = numbers[10]; // Invalid index
            System.out.println("Value at index 10: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds! Array has only 5 elements.");
        }
    }
}
