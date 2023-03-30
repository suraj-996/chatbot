
import Customer from "./component/Customer"
import Login from "./component/login"
import './App.css';
import React, { useState } from 'react';
import ChatBot from "./component/Chatbot";
// import User from "./component/User"
import { BrowserRouter, Route, Routes} from 'react-router-dom';
function App() {
  const [data, setData] = useState('');
  console.log(data)
  return (
    <div className="app">
      {/* <header>
        <h1>Chatbot</h1>
      </header> */}
      
      <BrowserRouter>
      <Routes>
      <Route path='/' element={<Customer></Customer>}></Route>
        <Route path='/login' element={<Login onRegister={(d)=>setData(d)}></Login>}></Route>
        <Route path='/user' element={<ChatBot className="box" data={data}></ChatBot>}></Route>
      </Routes>
      </BrowserRouter>
       
       {/* <Customer></Customer>*/}
       {/* <Login></Login> */}
       
    </div>
  );
}

export default App;
