import React, { Component } from 'react';
import Post from './Post';

/**
 * Class component representing a list of Blog Posts.
 */
class Posts extends Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            error: null
        };
        // Bind loadPosts to instance context
        this.loadPosts = this.loadPosts.bind(this);
    }

    /**
     * Fetches post records from jsonplaceholder API.
     */
    loadPosts() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to fetch blog post records from network API.');
                }
                return response.json();
            })
            .then(data => {
                // Slice data to top 20 posts for better layout visualization
                this.setState({ posts: data.slice(0, 20) });
            })
            .catch(err => {
                // Set local state error
                this.setState({ error: err });
                // Alert errors inside the catch handler
                alert("API fetch error: " + err.message);
            });
    }

    /**
     * Lifecycle method triggered when component mounts.
     */
    componentDidMount() {
        this.loadPosts();
    }

    /**
     * Error boundary lifecycle method to catch rendering exceptions in children.
     */
    componentDidCatch(error, errorInfo) {
        console.error("Caught error in Posts component:", error, errorInfo);
        this.setState({ error: error });
        alert("An error occurred during component rendering: " + error.message);
    }

    render() {
        if (this.state.error) {
            return (
                <div className="error-wrapper" style={{ padding: '20px', color: '#721c24', backgroundColor: '#f8d7da', border: '1px solid #f5c6cb', borderRadius: '5px' }}>
                    <h2>Oops! Something went wrong.</h2>
                    <p>{this.state.error.toString()}</p>
                </div>
            );
        }

        return (
            <div className="posts-container" style={{ maxWidth: '800px', margin: '0 auto', padding: '20px' }}>
                <h2 style={{ textAlign: 'left', color: '#0f172a', borderBottom: '2px solid #3b82f6', paddingBottom: '8px', marginBottom: '24px' }}>Blog Posts Feed</h2>
                <div className="posts-list">
                    {this.state.posts.map(post => (
                        <Post key={post.id} id={post.id} title={post.title} body={post.body} />
                    ))}
                </div>
            </div>
        );
    }
}

export default Posts;
