package shyftlab.be.studentcourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shyftlab.be.studentcourse.entity.Course;
import shyftlab.be.studentcourse.entity.Student;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


    @Query("SELECT c FROM Course c WHERE c.courseId IN :ids")
    List<Course> findAllByCourseIdsIn(@Param("ids") List<Long> ids);
}
