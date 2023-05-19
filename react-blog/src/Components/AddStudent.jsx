import React, { useState } from 'react';
import '../styles/AddStudent.css';
import axios from 'axios';

const AddStudent = () => {
  const [firstName, setFirstName] = useState('');
  const [familyName, setFamilyName] = useState('');
  const [dateOfBirth, setDateOfBirth] = useState('');
  const [emailAddress, setemailAddress] = useState('');
  const [error, setError] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    console.log(dateOfBirth)
    // Validate form inputs
    if (!firstName || !familyName || !dateOfBirth || !emailAddress) {
      setError('Please fill in all fields');
      return;
    }

    if (!isValidemailAddress(emailAddress)) {
        alert("Please enter a valid email address")
      setError('Please enter a valid emailAddress address');
      return;
    }

    const currentDate = new Date();
    const minimumAgeDate = new Date();
    minimumAgeDate.setFullYear(currentDate.getFullYear() - 10);

    if (new Date(dateOfBirth) > minimumAgeDate) {
      setError('The student must be at least 10 years old');
      return;
    }

    try {
      // Call the API to add a new student
      const response = await axios.post('http://localhost:8080/addstudent', {
        firstName,
        familyName,
        dateOfBirth,
        emailAddress,
      });

      // Handle the response and perform necessary actions
      console.log(response)
      // Clear form inputs
      setFirstName('');
      setFamilyName('');
      setDateOfBirth('');
      setemailAddress('');
      setError('');
      alert("The Student Added Successfully")
    } catch (error) {
      // Handle the error from the API
      
        alert(error.response.data['errorMessage'])
    }
  };

  const isValidemailAddress = (email) => {
    return String(email)
        .toLowerCase()
        .match(
        /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|.(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        );
  };

  return (
    <div className='register'>
      <h1>Please Add New Students</h1>
      <form className='register__form' onSubmit={handleSubmit}>
        <label>
            Enter First Name
          <input type="text" value={firstName} onChange={(e) => setFirstName(e.target.value)} required placeholder='Enter your first name' />
        </label>
        <label>
            Enter Family Name
          <input type="text" value={familyName} onChange={(e) => setFamilyName(e.target.value)} placeholder='Enter your family name' required/>
        </label>
        <label>
            Enter Date of Birth
          <input type="date" value={dateOfBirth} onChange={(e) => setDateOfBirth(e.target.value)} required />
        </label>
        <label>
            Enter Email Address
          <input type="emailAddress" value={emailAddress} onChange={(e) => setemailAddress(e.target.value)} placeholder='Enter your Email Address'
          required/>
        </label>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default AddStudent;



