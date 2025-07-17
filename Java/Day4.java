// Problem 4: Simple Student Class (Classes, Objects, Encapsulation, Constructors)
// Goal: Understand the basics of OOP: classes, objects, constructors, and encapsulation.
// Tasks:
// Create a class Student with the following private instance variables:
// String name
// int rollNumber
// double grade
// Create a constructor for Student that takes name, rollNumber, and grade as arguments and initializes the instance variables.
// Implement public getter methods for all instance variables (e.g., public String getName()).
// Implement public setter methods for name and grade (e.g., public void setGrade(double newGrade)).
// In a main method (e.g., in a School class):
// Create two Student objects using the constructor.
// Print their details using the getter methods.
// Use a setter method to update the grade of one student and print the updated details.
// Concepts Covered: Classes, Objects, Constructors, Instance variables, Encapsulation (private access modifier), Getters and Setters, this keyword.

public class School {

    
    static class Student {
        private String name;
        private int rollNumber;
        private double grade;

        
        public Student(String name, int rollNumber, double grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
        }

        
        public String getName() {
            return name;
        }

        public int getRollNumber() {
            return rollNumber;
        }

        public double getGrade() {
            return grade;
        }

      
        public void setName(String name) {
            this.name = name;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }
    }

    
    public static void main(String[] args) {
        Student student1 = new Student("Ajinkya", 101, 88.5);
        Student student2 = new Student("Riya", 102, 92.0);

        System.out.println("Student 1: " + student1.getName() + ", Roll No: " +
                student1.getRollNumber() + ", Grade: " + student1.getGrade());

        System.out.println("Student 2: " + student2.getName() + ", Roll No: " +
                student2.getRollNumber() + ", Grade: " + student2.getGrade());

       
        student1.setGrade(90.0);
        System.out.println("Updated Student 1 Grade: " + student1.getGrade());
    }
}
