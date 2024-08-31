import React, { useState } from 'react';

const LoginForm = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleUsernameChange = (e) => {
    setUsername(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    // Reset error message
    setError('');

    // Validate input
    if (!username || !password) {
      setError('Please enter both username and password');
      return;
    }

    // Simulate login
    if (username === 'admin' && password === 'password') {
      // Set isLoggedIn to true
      setIsLoggedIn(true);
    } else {
      setError('Invalid username or password');
    }
  };

  return (
    <div>
      {isLoggedIn ? (
        <Dashboard />
      ) : (
        <>
          <h2>Login</h2>
          {error && <p style={{ color: 'red' }}>{error}</p>}
          <form onSubmit={handleSubmit}>
            <div>
              <label htmlFor="username">Username:</label>
              <input
                type="text"
                id="username"
                value={username}
                onChange={handleUsernameChange}
              />
            </div>
            <div>
              <label htmlFor="password">Password:</label>
              <input
                type="password"
                id="password"
                value={password}
                onChange={handlePasswordChange}
              />
            </div>
            <button type="submit">Login</button>
          </form>
        </>
      )}
    </div>
  );
};

const Dashboard = () => {
  return <h2>Welcome to the Dashboard!</h2>;
};

export default LoginForm;
