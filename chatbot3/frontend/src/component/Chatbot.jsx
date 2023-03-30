import React, {useState, useEffect } from 'react';
import axios from 'axios';
import './chat.css';
function ChatBot(props) {
   
  const [message, setMessage] = useState('');
  const [chatHistory, setChatHistory] = useState([]);
  console.log(props);
  const jwtToken = localStorage.getItem('token');
  useEffect(() => {
    
    
    const url=`http://localhost:8080/chatbot/${props.data.custId}`
    axios.get(url, {
      headers: {
        'Authorization': `Bearer ${jwtToken}`
      }
    })
      .then(response => {
        setChatHistory(response.data);
      })
      .catch(error => console.log(error));
  }, [props.data.custId,jwtToken]);
  const handleChange = (event) => {
    setMessage(event.target.value);
  }
  console.log(props.data)
  const handleSubmit = (event) => {
    event.preventDefault();
    const requestData = {
      userId: props.data.custId,
      message: message
    };
    const headers={
      'Authorization': `Bearer ${jwtToken}`
    }
    axios.post('http://localhost:8080/chatbot',requestData,{
      headers:headers
    })
      .then(response => {
        console.log(response.data);
        setChatHistory([...chatHistory, response.data]);
        setMessage('');
      })
      .catch(error => console.log(error));
  }


    const changeTime=(input)=>{
        const time = new Date(input).toLocaleTimeString('en-US', {hour12: false, hour: '2-digit', minute: '2-digit'});
        console.log(time)
        return time;
    }

    const handleKeyDown = (event) => {
        if (event.key === 'Enter') {
          handleSubmit();
        }
    };

  return (
    <main className='chatbot'>
      <header>
        <h1>Chatbot</h1>
        <h4>Name - {props.data.name}</h4>
        <h4>Email - {props.data.email}</h4>
      </header>
      <article className='chat' role="list" aria-live='assertive'>
        
        <ul>
        {chatHistory.map((chatMessage) =>
          <li key={chatMessage.id} className="chat-details">
            <section className='time'>Time - {changeTime(chatMessage.timestamp)}</section>
            <section className='time'>{props.data.name} :</section>
            <section className='you'>{chatMessage.message}</section>
            <section className='time'>ChatBot:</section>
            <section className='chatbot'>{chatMessage.response}</section>
          </li>
        )}
      </ul>
      <section className='send'>
        <form onSubmit={handleSubmit} className="send-message">
        
            
        <label htmlFor="chat-text">Enter your message</label>
        <input type="text" 
          id='chat-text' 
          name='chat-text'
          value={message}
          onChange={handleChange}
          onKeyDown={handleKeyDown} 
          placeholder="Enter your message"/>
      
      <button className='chat-button' type="submit">Send</button>
    </form>
      </section>
      
      
    </article>
    </main>
  );
}

export default ChatBot;