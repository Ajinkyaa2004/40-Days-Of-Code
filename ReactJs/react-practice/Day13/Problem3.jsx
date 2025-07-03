// Problem 3: Basic To-Do List with List Rendering and State Updates
// Goal: Master list rendering with map and key, and managing arrays in state.
// Tasks:
// Create a component TodoList.
// Use useState to manage an array of to-do items. Each item should be an object like { id: 1, text: 'Learn React', completed: false }. Initialize with a few dummy items.
// Render each to-do item as an <li> element in an <ul>. Remember the key prop!
// Next to each to-do item, add a "Delete" button. When clicked, remove that item from the list.
// Add an input field and an "Add To-Do" button to add new items to the list. Ensure new items have a unique id.
// Concepts Covered: useState (with arrays), List Rendering (map, key), Event Handling, Immutability of State (when updating arrays).


import React, { useState } from 'react';

const TodoList = () => {
  const [todos, setTodos] = useState([
    { id: 1, text: 'Learn React', completed: false },
    { id: 2, text: 'Build a project', completed: false },
  ]);

  const [newTodo, setNewTodo] = useState('');

  const handleAdd = () => {
    if (newTodo.trim() === '') return;
    const newItem = {
      id: Date.now(),
      text: newTodo,
      completed: false,
    };
    setTodos([...todos, newItem]);
    setNewTodo('');
 };

  const handleDelete = (id) => {
    setTodos(todos.filter((todo) => todo.id !== id));
  };

  return (
    <div>
      <h2>My To-Do List</h2>
      <ul>
        {todos.map((todo) => (
          <li key={todo.id}>
            {todo.text}
            <button onClick={() => handleDelete(todo.id)}>Delete</button>
          </li>
        ))}
      </ul>
      <input
        type="text"
        value={newTodo}
        onChange={(e) => setNewTodo(e.target.value)}
        placeholder="New task"
      />
      <button onClick={handleAdd}>Add To-Do</button>
    </div>
  );
};

export default TodoList;
