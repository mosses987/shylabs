package shyftlab.be.studentcourse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shyftlab.be.studentcourse.StudentcourseApplication;
import shyftlab.be.studentcourse.entity.Student;
import shyftlab.be.studentcourse.error.InvalidInputException;
import shyftlab.be.studentcourse.repository.StudentRepository;

@Service
public class StudentService {

	
	@Autowired
	private StudentRepository studentRepository;
	
	
	public Optional<Student> addStudentService(Student student) throws InvalidInputException {
		
		// is empty return null
		if (checkIfEmpty(student.getEmailAddress()) || checkIfEmpty(student.getFamilyName()) || checkIfEmpty(student.getFirstName())) {
		    return null;
		}

		// else save the student
		return Optional.ofNullable(studentRepository.save(student));
		
	}
	
	
	public Optional<List<Student>> getAllStudent() {
		// gets list of student
		return Optional.ofNullable(studentRepository.findAll()) ;
		
	}


	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		 studentRepository.deleteById(id);
	}
	
	private boolean checkIfEmpty(String inputs) {
		if(inputs==null || inputs.isEmpty() || inputs.isBlank()) {
			return true;
		}
		
		return false;
	}



}
