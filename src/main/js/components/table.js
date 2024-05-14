import React from 'react';
import { BsFillPencilFill, BsFillTrash3Fill } from 'react-icons/bs';
import './table.css';
import { useEffect } from 'react';
import axios from 'axios';
import { useState } from 'react';
import {deleteExpense} from '../controller/mongo';


export default function Table(){

    const [budget, setbudget] = useState({expenses: {}});

    const getExpense = async() => {
        const result = await axios(
            `http://localhost:8080/expense`
        );
    
        console.log(result.data);

        setbudget({expenses: result.data});
    }

    /*Get initial expenses on first render*/
    useEffect(
        () => {
            getExpense();
        }, []
    )


  return (
    <div className='table-wrapper'>
        <table className='table'>
            <thead>
                <tr>
                    <th>Expense</th>
                    <th>Category</th>
                    <th>Budget</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                {
                    (budget.expenses || []).length > 0 ? (
                        budget.expenses.map((row) => {
                            return <tr key={row.id}>
                                    <td>{row.expenseName}</td>
                                    <td>{row.expenseCategory}</td>
                                    <td>{row.expenseAmount}</td>
                                    <td>
                                        <span className='label label-live'>Live</span>
                                    </td>
                                    <td>
                                        <span className='action'>
                                            <BsFillTrash3Fill className='delete-btn' onClick={() => {deleteExpense(row.id)}}/>
                                            <BsFillPencilFill />
                                        </span>
                                    </td>
                                </tr>
                        }
                    )
                    ) : (`No current expenses... :)`)
                }
            </tbody>
        </table>
    </div>
  )
}

