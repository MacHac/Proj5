package project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This serves as the base interface for all file-modification classes.
 * 
 * @author Alex Wilson
 */
public interface FileHandler {
    public void setFile(File f) throws FileNotFoundException;
    public void operate() throws FileNotFoundException, IOException;
}
