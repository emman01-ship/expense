import React from 'react';
import axios from 'axios';

export async function deleteExpense(id){
    console.log(id);
   await axios.delete(`http://localhost:8080/${id}`)
.then(response => {
console.log(`Deleted expense with ${id}`);
})
.catch(error => {
console.error(error);
});

}

export async function addExpense(expense){

    await axios.post(`http://localhost:8080/add`, 
    {
        expenseName: expense.expenseName,
        expenseCategory: expense.expenseCategory,
        expenseAmount: expense.expenseAmount,
        id: expense.id

    }
    )
    .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });


}
