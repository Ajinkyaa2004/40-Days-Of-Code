// Problem 3: Array Manipulator (Arrays, Loops, Array Methods)
// Goal: Practice common array operations.
// Tasks:
// Given an array of numbers: const numbers = [10, 25, 5, 40, 15, 30];
// Find Max: Write a function findMax(arr) that returns the largest number in the array.
// Filter Even: Write a function filterEven(arr) that returns a new array containing only the even numbers.
// Sum All: Write a function sumAll(arr) that returns the sum of all numbers in the array.
// Double Each: Write a function doubleEach(arr) that returns a new array where each number is doubled.
// Find Index: Write a function findIndex(arr, value) that returns the index of the value in the arr, or -1 if not found.
// Concepts Covered: Arrays, Array Methods (forEach, filter, reduce, map, indexOf or find), Loops (for), Functions.

const numbers = [10, 25, 5, 40, 15, 30];

function findMax(arr) {
  return Math.max(...arr);
}


function filterEven(arr) {
  return arr.filter(num => num % 2 === 0);
}


function sumAll(arr) {
  return arr.reduce((sum, num) => sum + num, 0);
}


function doubleEach(arr) {
  return arr.map(num => num * 2);
}


function findIndex(arr, value) {
  return arr.indexOf(value);
}
console.log(findMax(numbers));        
console.log(filterEven(numbers));    
console.log(sumAll(numbers));        
console.log(doubleEach(numbers));    
console.log(findIndex(numbers, 15)); 
console.log(findIndex(numbers, 99)); 
