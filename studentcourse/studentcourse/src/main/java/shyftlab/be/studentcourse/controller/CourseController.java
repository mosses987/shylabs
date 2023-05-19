package shyftlab.be.studentcourse.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import shyftlab.be.studentcourse.entity.Course;
import shyftlab.be.studentcourse.entity.TheId;
import shyftlab.be.studentcourse.entity.Course;
import shyftlab.be.studentcourse.error.InvalidInputException;
import shyftlab.be.studentcourse.error.ResourceNotFound;
import shyftlab.be.studentcourse.error.ServiceException;
import shyftlab.be.studentcourse.service.CourseService;
import shyftlab.be.studentcourse.service.StudentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CourseController {
	
	
	@Autowired
	private CourseService courseService;
	

	// this controller add course to DB
	@PostMapping("/addcourse")
	public ResponseEntity<String> addCourse(@RequestBody Course course) throws ServiceException {
	    try {
	    	// add course using course service
	        Optional<Course> createdStudent = courseService.addCourseService(course);
	
	     // checking the null and errors
	        if (createdStudent==null) {
	            throw new InvalidInputException("Invalid input: Please check the required fields");
	        }
	        
	        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Course created successfully");
	    } catch (InvalidInputException e) {
	        throw e; // Rethrow the InvalidInputException
	    } catch (Exception e) {
	        throw new ServiceException("Internal Server Exception while adding a course");
	    }
	}
	
	// this controller gives
	@GetMapping("/allcourse")
	public ResponseEntity<List<Course>> getAllCourse() throws ServiceException {

	    try {
	    	// retrieve course by using course service
	    	Optional<List<Course>> courseList = courseService.getAllCourse();
	
	    	// checking the null and errors
	        if (courseList==null || courseList.get().size()==0) {
	            throw new ResourceNotFound("There are no course available");
	        }
	        
	        return ResponseEntity.status(HttpStatus.ACCEPTED).body(courseList.get());
	    } catch (ResourceNotFound e) {
	        throw e; // Rethrow the InvalidInputException
	    } catch (Exception e) {
	        throw new ServiceException("Internal Server Exception while getting all courses");
	    }
	}
	

	// delete course according to ids
	@DeleteMapping("/deletecourse/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) throws ServiceException {
		try {
			courseService.deleteCourse(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Course deleted successfully");
		}catch (Exception e) {
			throw new ServiceException("Error while deleting a course");
		}
	}

}
