// Problem 3: Array Operations (Arrays, Loops)
// Goal: Work with one-dimensional arrays and loops.
// Tasks:
// Create a class ArrayOperations.
// In the main method, declare and initialize an integer array, e.g., int[] numbers = {10, 25, 5, 40, 15, 30};.
// Find Max: Write a loop to find and print the largest number in the array.
// Sum All: Write a loop to calculate and print the sum of all numbers in the array.
// Print Even: Write a loop to print only the even numbers from the array.
// Reverse Array: Create a new array and fill it with the elements of the numbers array in reverse order. Print the reversed array.
// Concepts Covered: Array declaration and initialization, array indexing, for loop, for-each loop (enhanced for loop).


public class ArrayOperations {
    public static void main(String[] args) {
        int[] numbers = {10, 25, 5, 40, 15, 30};

        // 🔹 Find Max
        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Maximum number: " + max);

        // 🔹 Sum All
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum of all numbers: " + sum);

        // 🔹 Print Even
        System.out.print("Even numbers: ");
        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        // 🔹 Reverse Array
        int[] reversed = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            reversed[i] = numbers[numbers.length - 1 - i];
        }

        System.out.print("Reversed array: ");
        for (int num : reversed) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
