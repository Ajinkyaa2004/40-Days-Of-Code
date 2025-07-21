// Problem 5: Shape Hierarchy (Inheritance, Method Overriding)
// Goal: Understand inheritance and method overriding.
// Tasks:
// Create an abstract class named Shape with:
// A protected String name variable.
// An abstract method public abstract double calculateArea().
// A concrete method public void display() { System.out.println("Shape: " + name); }.
// Create two classes that extend Shape: Circle and Rectangle.
// Circle should have a radius instance variable and implement calculateArea().
// Rectangle should have width and height instance variables and implement calculateArea().
// Each subclass should have a constructor that calls super() to set the name.
// In a main method (e.g., in Geometry class):
// Create objects of Circle and Rectangle.
// Call calculateArea() and display() on each object and print the results.
// Concepts Covered: Inheritance (extends), abstract classes and methods, Method Overriding, super keyword.

public class Geometry {
    abstract static class Shape {
        protected String name;

        public Shape(String name) {
            this.name = name;
        }

        public abstract double calculateArea();

        public void display() {
            System.out.println("Shape: " + name);
        }
    }

    static class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            super("Circle");
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }
    static class Rectangle extends Shape {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            super("Rectangle");
            this.width = width;
            this.height = height;
        }

        @Override
        public double calculateArea() {
            return width * height;
        }
    }
    public static void main(String[] args) {
        Circle c = new Circle(5.0);
        Rectangle r = new Rectangle(4.0, 6.0);

        c.display();
        System.out.println("Area: " + c.calculateArea());

        r.display();
        System.out.println("Area: " + r.calculateArea());
    }
}
