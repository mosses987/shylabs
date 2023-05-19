package shyftlab.be.studentcourse.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import shyftlab.be.studentcourse.entity.Course;
import shyftlab.be.studentcourse.entity.Result;
import shyftlab.be.studentcourse.entity.Student;
import shyftlab.be.studentcourse.entity.StudentCourse;
import shyftlab.be.studentcourse.entity.StudentCourseId;
import shyftlab.be.studentcourse.error.InvalidInputException;
import shyftlab.be.studentcourse.error.ResourceNotFound;
import shyftlab.be.studentcourse.error.ServiceException;
import shyftlab.be.studentcourse.repository.CourseRepository;
import shyftlab.be.studentcourse.repository.StudentCourseRepo;
import shyftlab.be.studentcourse.repository.StudentRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ResultController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentCourseRepo studentCourseRepository;
	
	// the course, student, and score
	@PostMapping("/addresult")
	public ResponseEntity<String> addResult(@RequestBody Result result) throws ServiceException {
	    try {
	    	
	    	// find courses
	        	Long courseId = result.getCourseId();
	        	Long studentId = result.getStudentId();
	
	        	Course course = courseRepository.findById(courseId)
	                    .orElseThrow(() -> new ResourceNotFound("Course not found with id: " + courseId));
	        	
	        	
	        	Student student = studentRepository.findById(studentId)
	                    .orElseThrow(() -> new ResourceNotFound("Course not found with id: " + studentId));
	        	
	        	// add to student course join table
	            StudentCourseId studentCourseId = new StudentCourseId(studentId, courseId);
	            StudentCourse studentCourse = new StudentCourse(studentCourseId, student, course, result.getScore());

	            // save to student_course table
	            studentCourseRepository.save(studentCourse);

	        return ResponseEntity.status(HttpStatus.ACCEPTED).body("result created successfully");
	    } catch (InvalidInputException e) {
	        throw e; // Rethrow the InvalidInputException
	    } catch (Exception e) {
	        throw new ServiceException(e.getMessage());
	    }
	}
	
	// get all the results from student_course table
	@GetMapping("/getresult")
	public ResponseEntity<List<StudentCourse>> getResult() throws ServiceException {
	    try {
	    	
	    	
	        return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentCourseRepository.findAll());
	    } catch (InvalidInputException e) {
	        throw e; // Rethrow the InvalidInputException
	    } catch (Exception e) {
	        throw new ServiceException(e.getMessage());
	    }
	}
}
