package shyftlab.be.studentcourse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shyftlab.be.studentcourse.entity.Course;
import shyftlab.be.studentcourse.entity.Student;
import shyftlab.be.studentcourse.entity.TheId;
import shyftlab.be.studentcourse.error.InvalidInputException;
import shyftlab.be.studentcourse.repository.CourseRepository;
import shyftlab.be.studentcourse.repository.StudentRepository;

@Service
public class CourseService {
	
	
	@Autowired
	private CourseRepository courseRepo;
	
	public Optional<Course> addCourseService(Course course) throws InvalidInputException {
		
		// is empty return null
		if (checkIfEmpty(course.getCourseName())) {
		    return null;
		}

		// else save the course
		return Optional.ofNullable(courseRepo.save(course));
		
	}
	
	public Optional<List<Course>> getAllCourse() {
		
		// gets list of courses
		return Optional.ofNullable(courseRepo.findAll()) ;
		
	}
	
	
	public void deleteCourse(Long id) {
		// TODO Auto-generated method stub
		 courseRepo.deleteById(id);
	}
	
	
	// check the validity of strings
	private boolean checkIfEmpty(String inputs) {
		if(inputs==null || inputs.isEmpty() || inputs.isBlank()) {
			return true;
		}
		
		return false;
	}

//	public Optional<List<Course>> getCoursesById(List<Long> theIds) {
//		// TODO Auto-generated method stub
//		return Optional.ofNullable(courseRepo.findAllByCourseIdsIn(theIds));
//	}

}
