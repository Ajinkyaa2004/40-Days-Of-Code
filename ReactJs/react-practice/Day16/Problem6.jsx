// Problem 7: Tabbed Interface with State and Conditional Rendering
// Goal: Implement a multi-tab view using state to manage the active tab.
// Tasks:
// Create a component Tabs.
// This component should manage its own activeTab state (e.g., useState(0) for the first tab).
// Render a list of tab "headers" (e.g., buttons or divs). When a header is clicked, update the activeTab state.
// Below the headers, conditionally render the content for the currently active tab.
// Example Data Structure for Tabs:const tabData = [
//   { title: 'Tab 1', content: 'Content for Tab 1.' },
//   { title: 'Tab 2', content: 'Content for Tab 2.' },
//   { title: 'Tab 3', content: 'Content for Tab 3.' },
// ];


// Render the Tabs component in App.jsx.
// Concepts Covered: useState, Event Handling, Conditional Rendering, List Rendering (map), Component Composition.

import React, { useState } from 'react';

// Tab Data
const tabData = [
  { title: 'Tab 1', content: 'Content for Tab 1.' },
  { title: 'Tab 2', content: 'Content for Tab 2.' },
  { title: 'Tab 3', content: 'Content for Tab 3.' },
];

// Tabs Component
function Tabs({ tabs }) {
  const [activeTab, setActiveTab] = useState(0);

  return (
    <div style={{ fontFamily: 'Arial', padding: '20px' }}>
      {/* Tab headers */}
      <div style={{ display: 'flex', gap: '10px', marginBottom: '10px' }}>
        {tabs.map((tab, index) => (
          <button
            key={index}
            onClick={() => setActiveTab(index)}
            style={{
              padding: '8px 16px',
              fontWeight: activeTab === index ? 'bold' : 'normal',
              borderBottom: activeTab === index ? '2px solid blue' : 'none',
              cursor: 'pointer',
              backgroundColor: 'white',
              border: '1px solid lightgray',
              borderRadius: '4px'
            }}
          >
            {tab.title}
          </button>
        ))}
      </div>

      {/* Tab content */}
      <div style={{ border: '1px solid #ccc', padding: '15px', borderRadius: '4px' }}>
        <p>{tabs[activeTab].content}</p>
      </div>
    </div>
  );
}

// App Component
function App() {
  return (
    <div>
      <h1>Tabbed Interface Example</h1>
      <Tabs tabs={tabData} />
    </div>
  );
}

export default App;
