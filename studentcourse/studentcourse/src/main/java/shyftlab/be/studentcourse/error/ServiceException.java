package shyftlab.be.studentcourse.error;

public class ServiceException extends Exception {

	public ServiceException() {}
	 
    public ServiceException(String message) {
        super(message);
    }
}
