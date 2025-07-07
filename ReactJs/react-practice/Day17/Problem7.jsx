// Problem 8: Simple Router for a Multi-Page App (using React Router DOM)
// Goal: Understand basic client-side routing with react-router-dom.
// Tasks:
// Install React Router: npm install react-router-dom
// Create three simple components: Home, About, Contact. Each should just display an <h1> with its name.
// In App.jsx:
// Wrap your application with BrowserRouter.
// Define Routes for /, /about, and /contact to render the respective components.
// Create a simple navigation bar (<nav>) with Link components to navigate between Home, About, and Contact.
// Bonus: Add a "Not Found" route (<Route path="*" element={<NotFound />} />) for unmatched paths.
// Concepts Covered: React Router DOM (BrowserRouter, Routes, Route, Link), Single Page Applications (SPAs).

import React from 'react';
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link
} from 'react-router-dom';

// Page Components
const Home = () => <h1>Home</h1>;
const About = () => <h1>About</h1>;
const Contact = () => <h1>Contact</h1>;
const NotFound = () => <h1>404 - Page Not Found</h1>;

function App() {
  return (
    <Router>
      <div style={{ padding: '20px', fontFamily: 'Arial' }}>
        {/* Navigation Bar */}
        <nav style={{ marginBottom: '20px' }}>
          <Link to="/" style={linkStyle}>Home</Link>
          <Link to="/about" style={linkStyle}>About</Link>
          <Link to="/contact" style={linkStyle}>Contact</Link>
        </nav>

        {/* Route Definitions */}
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </div>
    </Router>
  );
}

// Simple inline styling for links
const linkStyle = {
  marginRight: '15px',
  textDecoration: 'none',
  color: 'blue'
};

export default App;
