package project5;

/**
 * This is a custom wrapper for all IO exceptions.  Since I only care about
 * the message, not the stack trace, this simplifies things.
 * @author apw24164
 */
public class FileOperationFailedException extends Exception {
    String message;
    Throwable e;

    public FileOperationFailedException(String message, Throwable e) {
        super(message, e);
        this.message = message;
        this.e = e;
    }
    
    public String getMessage() {
        return message;
    }
}
