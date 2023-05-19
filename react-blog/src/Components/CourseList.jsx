import React, { useState, useEffect } from 'react';
import '../styles/StudentList.css';
import axios from 'axios';

const CourseList = () => {
  const [courses, setCourses] = useState([]);

  useEffect(() => {
    // Fetch the list of courses from the API
    fetchCourses();
  }, []);

  const fetchCourses = async () => {
    try {
      const response = await axios.get('http://localhost:8080/allcourse');
      setCourses(response.data);
      console.log(response.data)
    } catch (error) {
      console.error(error);
    }
  };

  const handleDelete = async (courseId) => {
    console.log(courseId)
    try {
      await axios.delete(`http://localhost:8080/deletecourse/${courseId}`);

      alert("course Deleted Successfully")
      // Refresh the list of courses
      fetchCourses();
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className='register'>
      <h1>List of Courses</h1>
      <table className='register__table'>
        <thead>
          <tr>
            <th>Course Name</th>

            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {courses.map((course) => (
            <tr key={course.courseId}>
              <td style={{ color: 'white' }}>{course.courseName}</td>
              <td>
                <button className='button' onClick={() => handleDelete(course.courseId)}>
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

export default CourseList;
