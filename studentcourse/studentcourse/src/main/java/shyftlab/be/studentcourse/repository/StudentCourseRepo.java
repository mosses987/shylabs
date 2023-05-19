package shyftlab.be.studentcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shyftlab.be.studentcourse.entity.Student;
import shyftlab.be.studentcourse.entity.StudentCourse;
import shyftlab.be.studentcourse.entity.StudentCourseId;

public interface StudentCourseRepo extends JpaRepository<StudentCourse, StudentCourseId> {

}
