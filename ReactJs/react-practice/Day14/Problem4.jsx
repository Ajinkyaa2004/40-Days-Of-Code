// Problem 5: Simple Data Fetcher with useEffect and Loading State
// Goal: Practice fetching data with fetch and managing loading/error states.
// Tasks:
// Create a component UserDataFetcher.
// Use useState to manage:
// userData: initialized to null.
// loading: initialized to true.
// error: initialized to null.
// Use useEffect to fetch data from https://jsonplaceholder.typicode.com/users/1 when the component mounts (empty dependency array []).
// Set loading to true before fetching.
// Upon successful fetch, set userData with the fetched data and set loading to false.
// Upon error, set error state with the error message and set loading to false.
// Conditionally render:
// "Loading..." if loading is true.
// "Error: [error message]" if error is not null.
// The user's name and email if userData is available.
// Concepts Covered: useEffect (for data fetching with empty dependency array), useState for multiple states, Conditional Rendering (loading/error/data states), Promises, fetch API.

import React, { useState, useEffect } from 'react';

function UserDataFetcher() {
  const [userData, setUserData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    setLoading(true); 
    fetch('https://jsonplaceholder.typicode.com/users/1')
      .then(response => {
        if (!response.ok) {
          throw new Error('Failed to fetch user data');
        }
        return response.json();
      })
      .then(data => {
        setUserData(data); 
        setLoading(false);
      })
      .catch(err => {
        setError(err.message);
        setLoading(false);
      });
  }, []);



  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error: {error}</p>;
  if (userData)
    return (
      <div>
        <h2>User Info</h2>
        <p><strong>Name:</strong> {userData.name}</p>
        <p><strong>Email:</strong> {userData.email}</p>
      </div>
    );
  return null;
}



function App() {
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>Simple Data Fetcher</h1>
      <UserDataFetcher />
    </div>
  );
}

export default App;
