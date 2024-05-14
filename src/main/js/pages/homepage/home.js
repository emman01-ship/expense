import React from 'react';
import Table from '../../components/table';
import './home.css';
import Model from '../../components/model';
import { useState } from 'react';

const Home = () => {
  const [model, setModel] = useState(false);

  return (
    <div className='all'>
        <h1>Welcome to your Expense page</h1>
        <h2>Manage your finances</h2>
        <Table/>
        <button className='btn'onClick={() => {setModel(true)}}>ADD</button>
        {model && <Model closeModel={() => {setModel(false)}}/>}
    </div>
  )
}

export default Home
