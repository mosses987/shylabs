import React, { useState, useEffect } from 'react';
import '../styles/StudentList.css';
import axios from 'axios';

const ResultList = () => {
  const [results, setResults] = useState([]);

  useEffect(() => {
    // Fetch the list of results from the API
    fetchResults();
  }, []);

  const fetchResults = async () => {
    try {
      const response = await axios.get('http://localhost:8080/getresult');
      setResults(response.data);

      console.log(response.data.map(i=>i.student.firstName))


         
    } catch (error) {
      console.error(error);
    }
  };



  return (
    <div className='register'>
      <h1>List of results</h1>
      <table className='register__table'>
        <thead>
          <tr>
            <th>Course</th>
            <th>Student</th>
            <th>Score</th>
          </tr>
        </thead>
        <tbody>
          {results.map((theREsult) => (
            <tr key={theREsult.id}>
              <td style={{ color: 'white' }}>{theREsult.course.courseName}</td>
              
              <td style={{ color: 'white' }}>{theREsult.student.firstName +" "+ theREsult.student.familyName}</td>
              <td style={{ color: 'white' }}>{theREsult.score}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ResultList;
