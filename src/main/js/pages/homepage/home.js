import React from 'react';
import Table from '../../components/table';
import './home.css';
import Model from '../../components/model';

const Home = () => {
  return (
    <div className='all'>
        <h1>Welcome to your Expense page</h1>
        <h2>Manage your finances</h2>
        <Table/>
        <Model/>
    </div>
  )
}

export default Home
