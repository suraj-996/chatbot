import React, { useState } from 'react';
import axios from 'axios';
import './user.css';
import { useNavigate } from 'react-router-dom'
const Login=(props)=> {
    const [password, setPassword] = useState('');
    const [email,setEmail]=useState('');
    const navigate=useNavigate();
    const handlePasswordChange = (event) => {
      setPassword(event.target.value);
    }

    const handleEmailChange = (event) => {
        setEmail(event.target.value);
    }
    
    const handleSubmit = (event) => {
      event.preventDefault();
      const url = 'http://localhost:8080/signIn';
      // const params = {
      //   email: email,
      //   password: password
      // };
      const headers = {
        'Authorization': 'Basic ' + btoa(email + ':' + password)
      };
      
      axios.get(url, {headers: headers })
      .then(response=>{
        props.onRegister(response.data);
        localStorage.setItem("token",response.headers.authorization);
        alert("User login successfully")
        navigate("/user")
      })
      .catch(error=>alert("username or password is wrong"));
      
    }
  
    return (
        <main >
            <header>
                <h1 className='login'>Login</h1>
            </header>
            <article className='user'>
        
                <form onSubmit={handleSubmit}>
                <label htmlFor="email">Email:</label>
                <br />
                <input type="email" value={email} id="email" name='email' onChange={handleEmailChange} />
                <br />
                <label htmlFor="password">Password:</label>
                <br />
                <input type="password" value={password} id="password" name='password' onChange={handlePasswordChange} />
                <br />
                <button type="submit">Sign In</button>
                </form>
            </article>
        </main>
      
    );
  }

export default Login;