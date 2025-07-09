// Problem 10: useToggle Custom Hook
// Goal: Understand how to create and use custom hooks to encapsulate reusable logic.
// Tasks:
// Create a custom hook called useToggle.js (or similar filename).
// It should accept an initialValue (boolean, default to false).
// It should use useState internally to manage its own boolean state.
// It should return the current boolean state and a toggle function that flips the state.
// Example: const [isOn, toggle] = useToggle(false);
// In App.jsx (or a new component ToggleExample):
// Import and use your useToggle hook.
// Display a message like "The light is: [ON/OFF]" based on the hook's state.
// Add a button "Toggle Light" that calls the toggle function from the hook.
// Bonus: Try using useToggle in another independent component to see how it encapsulates the logic.
// Concepts Covered: Custom Hooks, useState within a hook, Reusability of Logic, Separation of Concerns.
