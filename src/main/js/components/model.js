import React from 'react';
import './model.css';
import { addExpense } from '../controller/mongo';
import { useState } from 'react';

const Model = ({closeModel}) => {

  const [expenseValues, setExpense] = useState({
    expenseName: "",
    expenseCategory: "ENTERTAINMENT",
    amount: ""
  });

  const handleSubmit = (evt) => {
    evt.preventDefault();
    addExpense(
      expenseValues.expenseName, 
      expenseValues.expenseCategory,
      expenseValues.amount
    );
    closeModel();
    console.log(expenseValues);
  }

  const handleChange = (evt) => {
    // console.log(evt.target);
    const {name, value} = evt.target;
    setExpense({
      ...expenseValues,
      [name]: value
    });

  }

  return (
    <div className='model-container' onClick={
      (e) => {
        if(e.target.className === 'model-container'){
          closeModel();
        }
      }
    }>
        <div className='model'>
            <form onSubmit={handleSubmit}>
                <div className='form-group'>
                <label>Expense Name</label>
                <input 
                value={expenseValues.expenseName}
                name="expenseName"
                type="text"
                placeholder="expense"
                onChange={handleChange}
                ></input>
                </div>
                <div className='form-group'>
                <label>Category</label>
                <select
                name="expenseCategory" 
                value={expenseValues.expenseCategory}
                placeholder="category"
                onChange={handleChange}
                >
                    <option>ENTERTAINMENT</option>
                    <option>GROCERIES</option>
                    <option>RESTAURANT</option>
                    <option>UTILITIES</option>
                    <option>MISC</option>
                </select>

                </div>
                <div className='form-group'>
                <label>Budget</label>
                <input 
                value={expenseValues.amount}
                name="amount"
                placeholder="amount"
                onChange={handleChange}
                >
                </input>
                </div>
                <input
                className='btn'
                type="submit"
                value="Submit"
              />
                {/* <button 
                className='btn'
                onClick={handleSubmit}
                >Submit</button> */}
            </form>

        </div>
      
    </div>
  )
}

export default Model;
