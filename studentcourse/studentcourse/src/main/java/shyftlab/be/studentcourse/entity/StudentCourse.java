package shyftlab.be.studentcourse.entity;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourse implements Serializable {

    @EmbeddedId
    private StudentCourseId id;

//    @ManyToOne
//    @MapsId("studentId")
//    @JoinColumn(name = "student_id")
//    private Student student;
//
//    @ManyToOne
//    @MapsId("courseId")
//    @JoinColumn(name = "course_id")
//    private Course course;
    


    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", insertable = false, updatable = false)
    private Course course;

    private String score;


}
