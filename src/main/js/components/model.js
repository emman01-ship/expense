import React from 'react';
import './model.css';
import { addExpense } from '../controller/mongo';
import { updateExpense } from '../controller/mongo';
import { useState } from 'react';
import { v1 as uuidv1 } from 'uuid';

const Model = ({closeModel, add, defaultValue}) => {

  /*
    use either edited expense or blank one 
    default value can be null
  */
  const [expenseValues, setExpense] = useState( defaultValue ||
    {
    expenseName: "",
    expenseCategory: "ENTERTAINMENT",
    expenseAmount: "",
    id: uuidv1()
  });

  /* 
    only add a new expnese in back end if we we dont not have
    edited expense 
    if edited expense we call update expense
  */
  const handleSubmit = (evt) => {
    evt.preventDefault();
    
    console.log(expenseValues);
    if (defaultValue !== null ) {
      updateExpense(expenseValues);
    }

    if (defaultValue === null) addExpense(expenseValues);

    add(expenseValues);
    
    closeModel();
    
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
                value={expenseValues.expenseAmount}
                name="expenseAmount"
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
