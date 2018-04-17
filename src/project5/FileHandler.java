package project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Alex Wilson
 */
public interface FileHandler {
    public void setFile(File f) throws FileNotFoundException;
    public void operate() throws FileNotFoundException, IOException;
}
