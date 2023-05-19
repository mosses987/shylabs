import React from 'react';
import '../styles/Navbar.css';
import {Link} from 'react-router-dom'

function Navbar() {
    return (
            <div className='navbar'>
                <h2>Mosses's Blog.</h2>
            
                <div className='navbar__list'>
                    <ul>
                        <li>
                            <Link to="/Home">Home</Link>
                        </li>
                        <li>
                            <Link to="/addstudent">Add Student</Link>
                        </li>

                        <li>
                            <Link to="/liststudent">Student List</Link>
                        </li>
                        
                        <li>
                            <Link to="/addcourse">Add Course</Link>
                        </li>
                        <li>
                            <Link to="/listcourse">Course List</Link>
                        </li> 

                        <li>
                            <Link to="/addresult">Add Result</Link>
                        </li> 

                        <li>
                            <Link to="/resultlist">View Results</Link>
                        </li> 
                    </ul>
                </div>
            </div>
    )
}

export default Navbar
