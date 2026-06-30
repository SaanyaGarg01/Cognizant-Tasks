import React from 'react';
import Posts from './Posts';
import './App.css';

/**
 * Main App component rendering Posts component layout.
 */
function App() {
  return (
    <div className="App">
      <header className="App-header" style={{ backgroundColor: '#1e293b', minHeight: '12vh', display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center', fontSize: 'calc(10px + 2vmin)', color: 'white' }}>
        <h1>My Personal Blog App</h1>
      </header>
      
      <main style={{ backgroundColor: '#f8fafc', minHeight: '88vh' }}>
        <Posts />
      </main>
    </div>
  );
}

export default App;
