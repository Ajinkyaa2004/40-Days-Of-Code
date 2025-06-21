// Problem 4: Object Explorer (Objects, Destructuring)
// Goal: Work with JavaScript objects and access their properties.
// Tasks:
// Create an object user with properties: firstName, lastName, age, and an array of hobbies.const user = {
//     firstName: "Alice",
//     lastName: "Smith",
//     age: 30,
//     hobbies: ["reading", "hiking", "coding"]
// };
// Display Full Name: Write a function getFullName(userObj) that takes the user object and returns the full name (e.g., "Alice Smith").
// List Hobbies: Write a function listHobbies(userObj) that logs each hobby from the hobbies array to the console.
// Add New Property: Add a new property email to the user object.
// Update Age: Update the age property of the user object.
// Destructure User: Use object destructuring to extract firstName and age into separate variables. Log them.
// Concepts Covered: Objects, Object Properties, Object Methods, Arrays within Objects, Destructuring.

const user = {
  firstName: "Alice",
  lastName: "Smith",
  age: 30,
  hobbies: ["reading", "hiking", "coding"]
};

function getFullName(userObj){
    return `${userObj.firstName} ${userObj.lastName}`;
}
console.log(getFullName(user)); 

function listHobbies(userObj){
    userObj.hobbies.forEach(hobby => console.log(hobby));
}
listHobbies(user);

user.email = "alice@example.com";
user.age=31;

const{firstName,age}=user;
console.log("Destructured firstName:", firstName);
console.log("Destructured age:", age);

console.log("Full Name:", getFullName(user)); 
console.log("Hobbies:");
listHobbies(user);
console.log("Email:", user.email);