import React from 'react';
import { BsFillPencilFill, BsFillTrash3Fill } from 'react-icons/bs';
import './table.css';

const Table = () => {
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
                <td>Home</td>
                <td>Shopping</td>
                <td>$0</td>
                <td>
                    <span className='label label-live'>Live</span>
                </td>
                <td>
                    <span className='action'>
                        <BsFillTrash3Fill className='delete-btn'/>
                        <BsFillPencilFill />
                    </span>
                </td>
            </tbody>
        </table>
    </div>
  )
}

export default Table;
