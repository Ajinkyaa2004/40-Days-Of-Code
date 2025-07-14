// Problem 2: Grade Determiner (Control Flow - Conditionals)
// Goal: Practice conditional statements.
// Tasks:
// Create a class GradeDeterminer.
// Write a static method public static char getGrade(int score) that takes an integer score (0-100).
// The method should return a character grade based on these criteria:
// 90-100: 'A'
// 80-89: 'B'
// 70-79: 'C'
// 60-69: 'D'
// 0-59: 'F'
// Invalid scores (<0 or >100) should return 'X' or throw an IllegalArgumentException.
// In your main method, test the getGrade method with different scores and print the results.
// Concepts Covered: if-else if-else statements, return type char, method parameters, basic error handling.



class GradeDeterminer {
    public static char getGrade(int score) {
        if (score < 0 || score > 100) {
            return 'X';
        } else if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
public class Main {
    public static void main(String[] args) {
        int[] testScores = {95, 85, 75, 65, 55, -5, 110};

        for (int score : testScores) {
            char grade = GradeDeterminer.getGrade(score);
            System.out.println("Score: " + score + " => Grade: " + grade);
        }
    }
}
