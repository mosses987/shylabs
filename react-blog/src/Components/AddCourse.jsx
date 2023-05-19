import React, { useState } from 'react';
import '../styles/AddStudent.css';
import axios from 'axios';

const AddCourse = () => {
  const [courseName, setCourseName] = useState('');
  const [error, setError] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();


    // Validate form inputs
    if (!courseName) {
      setError('Please fill in all fields');
      return;
    }
    console.log(courseName)


    try {
      // Call the API to add a new student
      const response = await axios.post('http://localhost:8080/addcourse', {
        courseName
      });

      // Handle the response and perform necessary actions
      console.log(response)
      // Clear form inputs
      setCourseName('');
      setError('');
      alert("The Course Added Successfully")
    } catch (error) {
      // Handle the error from the API
      
        console.log(error.response)
    }
  };



  return (
    <div className='register'>
      <h1>Please Add New Courses</h1>
      <form className='register__form' onSubmit={handleSubmit}>
        <label>
            Enter The Course Name
          <input type="text" value={courseName} onChange={(e) => setCourseName(e.target.value)} placeholder='Enter the course name' />
        </label>

        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default AddCourse;



