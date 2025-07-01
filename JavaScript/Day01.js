// Problem 1: Basic Calculator (Syntax, Data Types, Operators, Functions)
// Goal: Create a set of functions for basic arithmetic operations.
// Tasks:
// Write a function add(a, b) that returns the sum of a and b.
// Write a function subtract(a, b) that returns the difference of a and b.
// Write a function multiply(a, b) that returns the product of a and b.
// Write a function divide(a, b) that returns the quotient of a and b. Handle division by zero by returning an appropriate message or null.
// Test your functions with various numbers and log the results to the console.
// Concepts Covered: Variables, Data Types (numbers), Arithmetic Operators, Functions, return statement, Conditional Statements.


function add(a,b){
    return a+b;
}

function subtract(a,b){
    return a-b;
}

function multiply(a,b){
    return a*b;
}

function divide(a,b){
    if(b===0){
        return "Not Possible ";
    }
        return a / b;
}

console.log("Add:",add(10,5));
console.log("Subtract:", subtract(10,5));
console.log("Multiply: ", multiply(10, 5)); 
console.log("Divide: ", divide(10, 5));  
console.log("Divide by Zero: ", divide(10, 0));
