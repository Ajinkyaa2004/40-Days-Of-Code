Problem 5: Shape Hierarchy (Inheritance, Method Overriding)
Goal: Understand inheritance and method overriding.
Tasks:
Create an abstract class named Shape with:
A protected String name variable.
An abstract method public abstract double calculateArea().
A concrete method public void display() { System.out.println("Shape: " + name); }.
Create two classes that extend Shape: Circle and Rectangle.
Circle should have a radius instance variable and implement calculateArea().
Rectangle should have width and height instance variables and implement calculateArea().
Each subclass should have a constructor that calls super() to set the name.
In a main method (e.g., in Geometry class):
Create objects of Circle and Rectangle.
Call calculateArea() and display() on each object and print the results.
Concepts Covered: Inheritance (extends), abstract classes and methods, Method Overriding, super keyword.
