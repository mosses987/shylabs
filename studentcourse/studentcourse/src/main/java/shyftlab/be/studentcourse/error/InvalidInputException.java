package shyftlab.be.studentcourse.error;

public class InvalidInputException extends RuntimeException {
	
	public InvalidInputException() {}
	 
    public InvalidInputException(String message) {
        super(message);
    }
}