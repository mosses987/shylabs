
import React, { useState, useEffect } from 'react';
import '../styles/AddResult.css';
import axios from 'axios';

const AddResult = () => {
  const [courses, setCourses] = useState([]);
  const [students, setStudents] = useState([]);
  const [selectedCourse, setSelectedCourse] = useState('');
  const [selectedStudent, setSelectedStudent] = useState('');
  const [selectedScore, setSelectedScore] = useState('');

  useEffect(() => {
    // Fetch the list of courses from the API
    fetchCourses();
    fetchStudents();
  }, []);

  const fetchCourses = async () => {
    try {
      const response = await axios.get('http://localhost:8080/allcourse');
      setCourses(response.data);
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const fetchStudents = async () => {
    try {
      const response = await axios.get('http://localhost:8080/allstudent');
      setStudents(response.data);
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const handleCourseChange = (e) => {
    const courseId = e.target.value;
    setSelectedCourse(courseId);
  };

  const handleStudentChange = (e) => {
    const studentId = e.target.value;
    setSelectedStudent(studentId);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
    const payload = {
      courseId: selectedCourse,
      studentId: selectedStudent,
      score: selectedScore,
    };
    console.log(payload)
      // Call the API to add a new student
      const response = await axios.post('http://localhost:8080/addresult', payload);

      console.log(response)
      console.log(payload)
      alert("Result Added Successfully")
      setSelectedCourse("")
      setSelectedScore("")
      setSelectedStudent("")

    } catch (error) {
      // Handle the error from the API
      
        console.log(error.response)
    }
  };

  return (
    <div className='register'>
      <h1>Please Add Results</h1>
      <form className='register__form' onSubmit={handleSubmit}>
        <label>
          Select Course:
          <select value={selectedCourse} onChange={handleCourseChange} required>
            <option value=''>Select a course</option>
            {courses.map((course) => (
              <option key={course.courseId} value={course.courseId}>
                {course['courseName']}
              </option>
            ))}
          </select>
        </label>
        <label>
          Select Student:
          <select value={selectedStudent} onChange={handleStudentChange} required>
            <option value=''>Select a student</option>
            {students.map((student) => (
              <option key={student.studentId} value={student.studentId}>
                {student.firstName} {student.familyName}
              </option>
            ))}
          </select>
        </label>

        <label>
          Select Score:
          <select value={selectedScore} onChange={(e) => setSelectedScore(e.target.value)} required>
            <option value=''>Select a score</option>
            <option value='A'>A</option>
            <option value='B'>B</option>
            <option value='C'>C</option>
            <option value='D'>D</option>
            <option value='E'>E</option>
            <option value='F'>F</option>
          </select>
        </label>

        <button type='submit'>Submit</button>
      </form>
    </div>
  );
};

export default AddResult;
