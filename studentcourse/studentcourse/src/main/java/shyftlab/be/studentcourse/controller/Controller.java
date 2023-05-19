package shyftlab.be.studentcourse.controller;


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
import shyftlab.be.studentcourse.entity.Student;
import shyftlab.be.studentcourse.entity.TheId;
import shyftlab.be.studentcourse.error.InvalidInputException;
import shyftlab.be.studentcourse.error.ResourceNotFound;
import shyftlab.be.studentcourse.error.ServiceException;
import shyftlab.be.studentcourse.service.StudentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Controller {
	
	
	@Autowired
	private StudentService studentService;
	
	

	// this controller add student to DB
	@PostMapping("/addstudent")
	public ResponseEntity<String> addStudent(@RequestBody Student student) throws ServiceException {
	    try {
	    	// add student by calling student service
	        Optional<Student> createdStudent = studentService.addStudentService(student);
	
	        // checking the null and errors
	        if (createdStudent==null) {
	            throw new InvalidInputException("Invalid input: Please check the required fields");
	        }
	        
	        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Student created successfully");
	    } catch (InvalidInputException e) {
	        throw e; // Rethrow the InvalidInputException
	    } catch (Exception e) {
	        throw new ServiceException("Internal Server Exception while adding a student");
	    }
	}
	
	// get all students from DB
	@GetMapping("/allstudent")
	public ResponseEntity<List<Student>> allStudent() throws ServiceException {

	    try {
	    	// get all students using student service
	    	Optional<List<Student>> studentList = studentService.getAllStudent();
	
	    	// checking the null and errors
	        if (studentList==null || studentList.get().size()==0) {
	            throw new ResourceNotFound("There are no students");
	        }
	        
	        return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentList.get());
	    } catch (ResourceNotFound e) {
	        throw e; // Rethrow the InvalidInputException
	    } catch (Exception e) {
	        throw new ServiceException("Internal Server Exception while getting all students");
	    }
	}
	
	
	// delete student according to ids
	@DeleteMapping("/deletestudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) throws ServiceException {
		try {
			// deleting student using student service
			studentService.deleteStudent(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Student deleted successfully");
		}catch (Exception e) {
			throw new ServiceException("Error while deleting a student");
		}
	}

}
