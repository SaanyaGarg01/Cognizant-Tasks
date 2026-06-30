# Student Score Calculator (scorecalculatorapp)

This project is a React web application demonstrating **Functional Components** in React. It renders a component that calculates a student's average score from the total score and target subjects goal.

---

## Technical Concept Walkthrough

### 1. What are React Components?
Components are independent and reusable bits of code. They serve the same purpose as JavaScript functions, but work in isolation and return HTML-like UI via JSX.

### 2. Functional Components
A **Functional Component** is a simple JavaScript function that accepts a single `props` object argument with data and returns React elements (JSX).
With the introduction of React Hooks, functional components have become the standard way to build React applications.

### 3. Difference: Components vs. JavaScript Functions
- **React Components**: Must return JSX, have Capitalized names, can receive dynamic properties (Props), and participate in React's component tree.
- **JavaScript Functions**: Can return any value, have lowercase names, receive standard parameter variables, and perform general computational logic.

### 4. Stylesheets in React
Styles can be applied to React components in three ways:
1. **Inline Styling**: Using camelCase properties inside double braces: `style={{ backgroundColor: 'red' }}`.
2. **External Stylesheets**: Creating a separate CSS file and importing it into the component: `import '../Stylesheets/mystyle.css'`.
3. **CSS Modules**: Scoped stylesheet configuration files.

In this project, we utilize **External Stylesheets** (`mystyle.css`) for consistent layout spacing, shadow formatting, and card definitions.

---

## Project Structure

```text
scorecalculatorapp/
│
├── package.json                        # Project metadata & dependency declarations
├── README.md                           # Documentation and guides
│
└── src/
    ├── App.js                          # Renders the Student Portal shell
    ├── App.css                         # App-wide base styles
    ├── index.js                        # Bootstraps React DOM root render context
    │
    ├── Components/                     # Sub-components directory
    │   └── CalculateScore.js           # Student Score Card functional component
    │
    └── Stylesheets/                    # Custom stylesheets folder
        └── mystyle.css                 # Score card visual style overrides
```

---

## How to Run the Application

1. Navigate into the `scorecalculatorapp` directory:
   ```bash
   cd scorecalculatorapp
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
