// Problem 2: Dynamic Welcome Message with Props and Conditional Rendering
// Goal: Understand props and different ways of conditional rendering.
// Tasks:
// Create a component Greeting that accepts a name prop (string) and an isLoggedIn prop (boolean).
// Inside Greeting:
// If isLoggedIn is true, display a message like "Welcome back, [name]!".
// If isLoggedIn is false, display "Please log in.".
// In App.jsx, render the Greeting component twice: once for a logged-in user and once for a guest.
// Example: <Greeting name="Alice" isLoggedIn={true} /> and <Greeting name="Guest" isLoggedIn={false} />
// Bonus: Add a button to App.jsx that toggles the isLoggedIn state for one of the Greeting components.
// Concepts Covered: Props, Conditional Rendering (if/else, ternary operator, logical &&), useState (for bonus).

import React, { useState } from 'react';

function Greeting({ name, isLoggedIn }) {
  return (
    <div>
      {isLoggedIn ? (
        <h2>Welcome back, {name}!</h2>
      ) : (
        <h2>Please log in.</h2>
      )}
    </div>
  );
}

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(true);

  const toggleLogin = () => setIsLoggedIn(prev => !prev);

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <Greeting name="Guest" isLoggedIn={false} />

      <Greeting name="Alice" isLoggedIn={isLoggedIn} />
      <button onClick={toggleLogin}>
        {isLoggedIn ? 'Log Out' : 'Log In'}
      </button>
    </div>
  );
}
export default App;
