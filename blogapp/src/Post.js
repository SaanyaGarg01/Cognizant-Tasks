import React from 'react';
import './Post.css';

/**
 * Functional component representing a single post item.
 */
function Post({ id, title, body }) {
    return (
        <div className="post-card" id={`post-${id}`}>
            <h3 className="post-title">{title}</h3>
            <p className="post-body">{body}</p>
        </div>
    );
}

export default Post;
