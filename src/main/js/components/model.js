import React from 'react';
import './model.css';

const Model = ({closeModel}) => {
  return (
    <div className='model-container' onClick={
      (e) => {
        if(e.target.className === 'model-container'){
          closeModel();
        }
      }
    }>
        <div className='model'>
            <form>
                <div className='form-group'>
                <label>Expense Name</label>
                <input name="expense"></input>
                </div>
                <div className='form-group'>
                <label>Category</label>
                <select name="category">
                    <option>ENTERTAINMENT</option>
                    <option>GROCERIES</option>
                    <option>RESTAURANT</option>
                    <option>UTILITIES</option>
                    <option>MISC</option>
                </select>

                </div>
                <div className='form-group'>
                <label>Budget</label>
                <input name="amount"></input>
                </div>
                <button class='btn'>Submit</button>
            </form>

        </div>
      
    </div>
  )
}

export default Model;
