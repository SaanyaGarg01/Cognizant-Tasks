import React, { Component } from 'react';

class Home extends Component {
  render() {
    return (
      <div className="card home-card" id="home-section">
        <div className="card-header">
          <div className="icon-container">
            <span role="img" aria-label="home">🏠</span>
          </div>
          <h2>Home</h2>
        </div>
        <div className="card-body">
          <p className="welcome-message">
            Welcome to the Home page of Student Management Portal
          </p>
        </div>
      </div>
    );
  }
}

export default Home;
