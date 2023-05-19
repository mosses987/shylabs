import React, { useState, useEffect } from 'react';
import '../styles/StudentList.css';
import axios from 'axios';

const StudentList = () => {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    // Fetch the list of students from the API
    fetchStudents();
  }, []);

  const fetchStudents = async () => {
    try {
      const response = await axios.get('http://localhost:8080/allstudent');
      setStudents(response.data);
    } catch (error) {
      console.error(error);
    }
  };

    const formatDate = (dateString) => {
      const dateParts = dateString.split('-');
      const year = dateParts[0];
      const month = dateParts[1];
      const day = dateParts[2];

      return `${month}/${day}/${year}`;
  };

  const handleDelete = async (studentId) => {
    console.log(studentId)
    try {
      await axios.delete(`http://localhost:8080/deletestudent/${studentId}`);

      alert("Student Deleted Successfully")
      // Refresh the list of students
      fetchStudents();
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className='register'>
      <h1>List of Students</h1>
      <table className='register__table'>
        <thead>
          <tr>
            <th>Name & Family Name</th>
            
            <th>Date of Birth</th>
            <th>Email</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {students.map((student) => (
            <tr key={student.studentId}>
              <td style={{ color: 'white' }}>{student.firstName +" "+ student.familyName}</td>
              
              <td style={{ color: 'white' }}>{
                formatDate(student.dateOfBirth)
              }</td>
              <td style={{ color: 'white' }}>{student.emailAddress}</td>
              <td>
                <button className='button' onClick={() => handleDelete(student.studentId)}>
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default StudentList;
