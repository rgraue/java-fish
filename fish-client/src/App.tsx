import React from 'react';
import logo from './logo.svg';
import './App.css';

function App() {
  const handleButton = async () => {
    const result = await fetch('http://localhost:8080/api');
    console.log(await result.text());
  }

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <button onClick={handleButton}>hit</button>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
