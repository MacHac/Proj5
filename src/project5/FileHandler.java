package project5;


/**
 * This serves as the base interface for all file-modification classes.
 * 
 * @author Alex Wilson
 */
public interface FileHandler {
    public void run() throws FileOperationFailedException;
    public void setData(String data);
    public String getData();
}
