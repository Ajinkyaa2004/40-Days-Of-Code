// Problem 1: Basic Calculator (Syntax, Data Types, Operators, Methods)
// Goal: Understand basic Java syntax, variables, operators, and method creation.
// Tasks:
// Create a class named Calculator.
// Inside Calculator, define static methods for basic arithmetic operations:
// public static int add(int a, int b)
// public static int subtract(int a, int b)
// public static int multiply(int a, int b)
// public static double divide(double a, double b) (handle division by zero by returning a special value like Double.NaN or printing an error).
// In a main method (e.g., in a separate Main class), call these methods with various numbers and print the results to the console using System.out.println().
// Concepts Covered: Basic syntax, main method, System.out.println(), primitive data types (int, double), arithmetic operators, static methods.


class Calculator {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero");
            return Double.NaN;
        }
        return a / b;
    }
}


public class Main {
    public static void main(String[] args) {

        System.out.println("Addition: " + Calculator.add(10, 5));
        System.out.println("Subtraction: " + Calculator.subtract(10, 5));
        System.out.println("Multiplication: " + Calculator.multiply(10, 5));
        System.out.println("Division: " + Calculator.divide(10, 5));
        System.out.println("Division by zero: " + Calculator.divide(10, 0));
    }
}
