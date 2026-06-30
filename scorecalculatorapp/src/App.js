import React from 'react';
import CalculateScore from './Components/CalculateScore';
import './App.css';

/**
 * Main application component invoking CalculateScore component.
 */
function App() {
  return (
    <div className="App">
      <header className="App-header" style={{ backgroundColor: '#282c34', minHeight: '15vh', display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center', fontSize: 'calc(10px + 2vmin)', color: 'white' }}>
        <h1>Student Management Portal</h1>
      </header>
      
      <main style={{ padding: '20px' }}>
        <CalculateScore 
          Name="Siddharth Roy" 
          School="St. Xavier's High School" 
          Total={445} 
          goal={5} 
        />
      </main>
    </div>
  );
}

export default App;
