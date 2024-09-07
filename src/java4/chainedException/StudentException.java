package java4.chainedException;

public class StudentException extends Exception {
	 
    public StudentException(String message) {
        super(message);
    }
 
    public StudentException(String message, Throwable cause) {
        super(message, cause);
    }
 
}
