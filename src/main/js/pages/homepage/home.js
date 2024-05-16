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

  const [expenseToEdit, editExpense] = useState(null);

  const handleEdit = (idx) => {
    editExpense(idx);
    setModel(true);
  }

    const getExpense = async() => {
        const result = await axios(
            `http://localhost:8080/expense`
        );
    
        console.log(result.data);

        setbudget(result.data);
    }

    /*
      functionality for both add and update
      check first if there is any expense that needs to
      be edited, 
      if null row is being added so we add as normal
      if not null
      we set the budget with current expense that we are at

    */

    const setExpense = (ex) => {
      expenseToEdit === null ? 
      setbudget([...budget, ex]) : 
      setbudget(budget.map((currExpense, idx) => 
        {
          if(idx !== expenseToEdit) return currExpense;
          return ex;
        })
      );

    }

    const deleteExpense = (id) => {
      setbudget(budget.filter((_, idx) => idx !== id));
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
        {(budget || []).length > 0 ? 
        (
        <Table 
          budget={budget} 
          delExpense={deleteExpense}
          update={handleEdit}
        />
          ) : ([])}
        <button className='btn'onClick={() => setModel(true)}>ADD</button>        
        {/* <button className='btn'onClick={() => {setModel(true)}}>ADD</button> */}
        {model && 
          <Model 
            closeModel={() => {setModel(false)}} add={setExpense}
            defaultValue={(expenseToEdit != null && budget[expenseToEdit]) || expenseToEdit}
          />
        }
    </div>
  )
}

export default Home
