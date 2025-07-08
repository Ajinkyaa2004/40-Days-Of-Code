// Problem 9: Theme Switcher with Context API
// Goal: Use the Context API to manage a global state (theme) without prop drilling.
// Tasks:
// Create a ThemeContext using React.createContext(). This context will hold the current theme ('light' or 'dark') and a function to toggle it.
// In App.jsx:
// Manage the theme state using useState.
// Provide the theme state and a toggleTheme function via the ThemeContext.Provider to the entire application.
// Create a ThemeButton component that uses useContext to:
// Read the current theme.
// Call the toggleTheme function when clicked.
// Display "Switch to Dark Mode" or "Switch to Light Mode" based on the current theme.
// Create a ThemedParagraph component that uses useContext to:
// Read the current theme.
// Apply different inline styles (e.g., backgroundColor, color) based on the theme.
// Render the ThemeButton and ThemedParagraph components in App.jsx.
// Concepts Covered: Context API (createContext, Provider, useContext), Global State Management, Props vs. Context.


import React, { useState, createContext, useContext } from 'react';


const ThemeContext = createContext();


function ThemeButton() {
  const { theme, toggleTheme } = useContext(ThemeContext);

  return (
    <button onClick={toggleTheme} style={{ marginBottom: '15px' }}>
      {theme === 'light' ? 'Switch to Dark Mode' : 'Switch to Light Mode'}
    </button>
  );
}

function ThemedParagraph() {
  const { theme } = useContext(ThemeContext);

  const style = {
    padding: '15px',
    borderRadius: '6px',
    backgroundColor: theme === 'light' ? '#f0f0f0' : '#333',
    color: theme === 'light' ? '#000' : '#fff'
  };

  return <p style={style}>This is a themed paragraph based on the current theme.</p>;
}


function App() {
  const [theme, setTheme] = useState('light');


  const toggleTheme = () => {
    setTheme(prev => (prev === 'light' ? 'dark' : 'light'));
  };

  return (
    <ThemeContext.Provider value={{ theme, toggleTheme }}>
      <div style={{ padding: '20px', fontFamily: 'Arial' }}>
        <h1>Theme Switcher with Context API</h1>
        <ThemeButton />
        <ThemedParagraph />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
