Problem 6: Polymorphism Example (Polymorphism, Arrays of Objects)
Goal: Demonstrate polymorphism using a common superclass reference.
Tasks:
Reuse the Shape, Circle, and Rectangle classes from Problem 5.
In your main method (e.g., in PolyDemo class):
Declare an array of Shape objects, e.g., Shape[] shapes = new Shape[3];.
Populate this array with instances of Circle and Rectangle.
Use a for-each loop to iterate through the shapes array.
Inside the loop, call calculateArea() and display() on each Shape object. Observe how the correct calculateArea() method (from the actual object type) is invoked.
Concepts Covered: Polymorphism (runtime), Array of objects, for-each loop.
