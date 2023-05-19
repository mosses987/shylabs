package shyftlab.be.studentcourse.error;

public class ResourceNotFound extends RuntimeException {
	
	public ResourceNotFound() {}
	 
    public ResourceNotFound(String message) {
        super(message);
    }
}