package shyftlab.be.studentcourse.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

	
	public Long courseId;
	public Long studentId;
	public String score;
}
