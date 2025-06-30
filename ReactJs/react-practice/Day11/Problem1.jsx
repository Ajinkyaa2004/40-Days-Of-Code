// Problem 1: Simple Counter with State and Event Handling
// Goal: Understand useState and basic event handling.
// Tasks:
// Create a functional component Counter.
// Inside Counter, use the useState hook to manage a count variable, initialized to 0.
// Display the current count value in a <p> tag.
// Add two buttons: "Increment" and "Decrement".
// When "Increment" is clicked, increase the count by 1.
// When "Decrement" is clicked, decrease the count by 1.
// Concepts Covered: Functional Components, JSX, useState, Event Handling (onClick).


import React, {useState} from 'react';
function Counter() {
    const [count, setCount]=useState(0);
     const increment = () => setCount(count + 1);
     const decrement = () => setCount(count - 1);

     return(
        <div>
            <h2>
                Simple Counter
            </h2>
            <p>
                Count: {count} 
            </p>
            <button onClick={increment}> Increment</button>
             <button onClick={decrement}> Decrement</button>
        </div>
     );
} 
export default Counter;