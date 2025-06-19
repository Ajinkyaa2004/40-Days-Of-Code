// Problem 2: Grade Calculator (Conditional Statements, Functions)
// Goal: Determine a student's grade based on their score.
// Tasks:
// Write a function getGrade(score) that takes a numerical score (0-100) as input.
// The function should return a letter grade based on the following criteria:
// 90-100: 'A'
// 80-89: 'B'
// 70-79: 'C'
// 60-69: 'D'
// 0-59: 'F'
// Handle invalid scores (e.g., less than 0 or greater than 100) by returning an error message.
// Test with various scores to ensure correct grading.
// Concepts Covered: Functions, Parameters, Conditional Statements (if/else if/else), Comparison Operators.


function getGrade (score){
    if(score < 0 || score > 100){
        return "Invalid score, Must be Between 0 to 100";
    }

    if (score >= 90){
        return 'A';
    }
    else if (score >= 80){
        return 'B';
    }
    else if ( score >= 70){
        return 'C';
    }
    else if (score >= 60){
        return 'D'
    }
    else {
        return 'F'
    }
}

console.log("Score 95 , Grade ", getGrade(95));
console.log("Score 82 , Grade:", getGrade(82));    
console.log("Score 74 , Grade:", getGrade(74));    
console.log("Score 65 , Grade:", getGrade(65));    
console.log("Score 40 , Grade:", getGrade(40)); 

console.log("Score 101 , Grade:", getGrade(110)); 
console.log("Score -5 , Grade:", getGrade(-5));

