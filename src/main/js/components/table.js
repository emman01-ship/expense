import React from 'react';
import { BsFillPencilFill, BsFillTrash3Fill } from 'react-icons/bs';
import './table.css';
import {deleteExpense} from '../controller/mongo';

export default function Table({budget}){

  return (
    <>
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
                    (budget || []).length > 0 ? (
                        budget.map((row) => {
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
                        ) : []
                    }
                </tbody>
            </table>
        </div>
    </>
    
  )
}

