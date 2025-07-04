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

import React, { useState } from 'react';
function Modal({ isOpen, onClose, children }) {
  if (!isOpen) return null; 
  return (
    <div style={styles.overlay}>
      <div style={styles.modal}>
        {children}
        <button onClick={onClose}>Close</button>
      </div>
    </div>
  );
}

function App() {
  const [isModalOpen, setIsModalOpen] = useState(false);

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>Modal Demo</h1>
      <button onClick={() => setIsModalOpen(true)}>Open Modal</button>

      <Modal isOpen={isModalOpen} onClose={() => setIsModalOpen(false)}>
        <p>This is modal content!</p>
      </Modal>
    </div>
  );
}

const styles = {
  overlay: {
    position: 'fixed',
    top: 0,
    left: 0,
    width: '100vw',
    height: '100vh',
    backgroundColor: 'rgba(0,0,0,0.5)',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    zIndex: 1000
  },
  modal: {
    backgroundColor: 'white',
    padding: '20px',
    borderRadius: '8px',
    boxShadow: '0 2px 10px rgba(0,0,0,0.3)',
    minWidth: '300px',
    textAlign: 'center'
  }
};
export default App;
