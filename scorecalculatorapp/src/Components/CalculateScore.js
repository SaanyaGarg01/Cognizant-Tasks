import React from 'react';
import '../Stylesheets/mystyle.css';

/**
 * Functional component to calculate and render a student's average score.
 */
function CalculateScore({ Name, School, Total, goal }) {
    // Calculate average score
    const average = (Total / goal).toFixed(2);

    return (
        <div className="score-card">
            <h2 className="score-header">Student Score Card</h2>
            <div className="score-details">
                <p><strong>Student Name:</strong> {Name}</p>
                <p><strong>School Name:</strong> {School}</p>
                <p><strong>Total Score:</strong> {Total}</p>
                <p><strong>Goal (Subjects):</strong> {goal}</p>
                <p className="score-average"><strong>Average Score:</strong> {average}</p>
            </div>
        </div>
    );
}

export default CalculateScore;
