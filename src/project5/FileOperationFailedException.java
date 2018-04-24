package project5;

/**
 *
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
