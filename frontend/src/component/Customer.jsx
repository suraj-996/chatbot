import React, { useState } from 'react';
import axios from 'axios';
import './user.css';
import { useNavigate } from 'react-router-dom'
const Customer=()=> {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [email,setEmail]=useState('');
    const navigate=useNavigate();
    const handleUsernameChange = (event) => {
      setUsername(event.target.value);
    }
  
    const handlePasswordChange = (event) => {
      setPassword(event.target.value);
    }

    const handleEmailChange = (event) => {
        setEmail(event.target.value);
    }
    
    const handleSubmit = (event) => {
      event.preventDefault();
      const requestData = {
        name: username,
        email:email,
        password: password
      };
      axios.post('http://localhost:8080/signup', requestData)
        .then(response => {
          console.log(response.data);
          alert("Usr registered successfully")
        })
        .catch(error => alert("user already registerd, you can login"));
        navigate("/login")
    }
  
    return (
        <main>
            <header>
                <h1>SignUp</h1>
            </header>
            <article className='user'>
        
                <form onSubmit={handleSubmit}>
                <label htmlFor="username">Username:</label>
                <br />
                <input type="text" value={username} id="username" name='username' onChange={handleUsernameChange} />
                <br />
                <label htmlFor="email">Email:</label>
                <br />
                <input type="email" value={email} id="email" name='email' onChange={handleEmailChange} />
                <br />
                <label htmlFor="password">Password:</label>
                <br />
                <input type="password" value={password} id="password" name='password' onChange={handlePasswordChange} />
                <br />
                <button type="submit">Register</button>
                </form>
            </article>
        </main>
      
    );
  }

export default Customer;