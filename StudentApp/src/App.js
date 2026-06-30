import React, { Component } from 'react';
import Home from './Components/Home';
import About from './Components/About';
import Contact from './Components/Contact';
import './index.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="portal-header">
          <h1>Student Management Portal</h1>
          <p>Explore resources and contact details for the student community</p>
        </header>

        <main className="components-grid">
          <Home />
          <About />
          <Contact />
        </main>

        <footer className="portal-footer">
          <p>&copy; {new Date().getFullYear()} Student Management Portal. All rights reserved.</p>
        </footer>
      </div>
    );
  }
}

export default App;
