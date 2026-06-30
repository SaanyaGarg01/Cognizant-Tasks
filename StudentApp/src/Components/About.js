import React, { Component } from 'react';

class About extends Component {
  render() {
    return (
      <div className="card about-card" id="about-section">
        <div className="card-header">
          <div className="icon-container">
            <span role="img" aria-label="info">ℹ️</span>
          </div>
          <h2>About</h2>
        </div>
        <div className="card-body">
          <p className="welcome-message">
            Welcome to the About page of the Student Management Portal
          </p>
        </div>
      </div>
    );
  }
}

export default About;
