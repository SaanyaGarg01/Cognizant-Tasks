# Personal Blog Application (blogapp)

This project is a React web application demonstrating the **React Component Lifecycle** using Class Components. It fetches mock blog posts from JSONPlaceholder using Fetch API and renders them with styling.

---

## Technical Concept Walkthrough

### 1. The Need & Benefits of the Component Lifecycle
In a React application, components are created, updated, and deleted. Having access to these transitions (called **Lifecycle Methods**) is crucial for:
- Fetching initial server data asynchronously (AJAX / REST requests).
- Setting up event listeners, timers, or socket connections.
- Optimizing render performance to prevent unnecessary updates.
- Cleaning up resources when a component is destroyed to avoid memory leaks.

---

### 2. Various Lifecycle Hook Methods
React class components have lifecycle hooks divided into three main phases:

#### A. Mounting Phase (Creation)
1. **`constructor()`**: Initializes state, binds handler methods.
2. **`static getDerivedStateFromProps()`**: Syncs state with prop updates.
3. **`render()`**: Prepares JSX elements for the DOM tree.
4. **`componentDidMount()`**: Runs immediately after the component is rendered on screen. Ideal for API data fetches.

#### B. Updating Phase (Re-rendering on Prop/State Change)
1. **`static getDerivedStateFromProps()`**
2. **`shouldComponentUpdate()`**: Optimizes rendering (returns true/false).
3. **`render()`**
4. **`getSnapshotBeforeUpdate()`**: Captures current DOM properties (like scroll offset).
5. **`componentDidUpdate()`**: Runs immediately after an update has been committed to the DOM.

#### C. Unmounting Phase (Destruction)
1. **`componentWillUnmount()`**: Invoked immediately before component destruction. Good for removing event listeners and invalidating timers.

#### D. Error Handling Phase
1. **`static getDerivedStateFromError()`**: Renders a fallback UI.
2. **`componentDidCatch()`**: Logs error details and displays alert scopes.

---

### 3. Rendering sequence of steps:
1. React executes the component `constructor()`.
2. The initial `render()` function executes, preparing the virtual nodes.
3. React inserts the node updates into the browser DOM.
4. React calls **`componentDidMount()`**.
5. When state variables mutate or props update, React triggers the update cycle, calling `render()` again to calculate differences, flushing updates to the real DOM.
6. Before removal, `componentWillUnmount()` executes.

---

## How to Run the Application

1. Navigate to the `blogapp` directory:
   ```bash
   cd blogapp
   ```
2. Build/Sync node packages (if not already downloaded):
   ```bash
   npm install
   ```
3. Run the development server:
   ```bash
   npm start
   ```
4. Open your browser and navigate to:
   [http://localhost:3000](http://localhost:3000)
