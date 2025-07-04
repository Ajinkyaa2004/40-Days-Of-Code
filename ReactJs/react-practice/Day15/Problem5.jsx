// Problem 6: Modal Component with Props and State
// Goal: Create a reusable component that uses props for configuration and state for internal behavior.
// Tasks:
// Create a Modal component that:
// Accepts isOpen (boolean) and onClose (function) as props.
// Conditionally renders a modal dialog if isOpen is true.
// The modal should have a "Close" button inside it that calls onClose.
// The modal content should be passed as children prop.
// In App.jsx:
// Use useState to control the isModalOpen state.
// Add a button "Open Modal". When clicked, set isModalOpen to true.
// Pass the state and a function to close the modal (setIsModalOpen(false)) to the Modal component.
// Render some content inside the Modal (e.g., <p>This is modal content!</p>).
// Concepts Covered: Props (children), useState for component state, Conditional Rendering, Event Handling, Reusable Components.

