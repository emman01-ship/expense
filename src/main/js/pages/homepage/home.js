import React from 'react';
import Table from '../../components/table';
import './home.css';
import Model from '../../components/model';
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';

const Home = () => {
  const [model, setModel] = useState(false);

  const [budget, setbudget] = useState();

    const getExpense = async() => {
        const result = await axios(
            `http://localhost:8080/expense`
        );
    
        console.log(result.data);

        setbudget(result.data);
    }


    const setExpense = (ex) => {
      setbudget([...budget, ex]);
    }



    /*Get initial expenses on first render*/
    useEffect(
        () => {
            getExpense();
        }, []
    )

  return (
    <div className='all'>
        <h1>Welcome to your Expense page</h1>
        <h2>Manage your finances</h2>
        {(budget || []).length > 0 ? (<Table budget={budget}/>) : ([])}
        <button className='btn'onClick={() => setModel(true)}>ADD</button>        
        {/* <button className='btn'onClick={() => {setModel(true)}}>ADD</button> */}
        {model && <Model closeModel={() => {setModel(false)}} add={setExpense}/>}
    </div>
  )
}

export default Home
