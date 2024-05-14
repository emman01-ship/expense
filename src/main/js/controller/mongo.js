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