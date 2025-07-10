// Problem 4: Character Counter (Input Handling and useEffect - Basic)
// Goal: Understand controlled components for forms and basic useEffect usage.
// Tasks:
// Create a component CharacterCounter.
// Use useState to manage the text entered in a <textarea>.
// Display the current number of characters typed below the textarea.
// Use useEffect to log the character count to the console every time the text changes.
// Concepts Covered: Controlled Components (textarea), useState, useEffect (with dependency array), Event Handling (onChange).



import React, { useState, useEffect } from 'react';

function CharacterCounter() {
  const [text, setText] = useState('');

  useEffect(() => {
    console.log(`Character count: ${text.length}`);
  }, [text]); 

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h2>Character Counter</h2>
      <textarea
        value={text}
        onChange={(e) => setText(e.target.value)}
        rows="5"
        cols="40"
        placeholder="Type something..."
        style={{ padding: '8px', fontSize: '16px' }}
      />
      <p>Character Count: {text.length}</p>
    </div>
  );
}

function App() {
  return (
    <div>
      <CharacterCounter />
    </div>
  );
}

export default App;
