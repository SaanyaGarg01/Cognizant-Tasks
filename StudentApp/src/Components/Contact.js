import React, { Component } from 'react';

class Contact extends Component {
  render() {
    return (
      <div className="card contact-card" id="contact-section">
        <div className="card-header">
          <div className="icon-container">
            <span role="img" aria-label="contact">📞</span>
          </div>
          <h2>Contact</h2>
        </div>
        <div className="card-body">
          <p className="welcome-message">
            Welcome to the Contact page of the Student Management Portal
          </p>
        </div>
      </div>
    );
  }
}

export default Contact;
