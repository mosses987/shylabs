package shyftlab.be.studentcourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shyftlab.be.studentcourse.entity.Student;
import shyftlab.be.studentcourse.entity.StudentCourse;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.studentId IN :ids")
    List<Student> findAllByStudentIdIn(@Param("ids") List<Long> ids);

}
