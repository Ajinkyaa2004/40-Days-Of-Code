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
