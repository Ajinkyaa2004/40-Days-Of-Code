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
