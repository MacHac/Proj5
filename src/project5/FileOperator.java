package project5;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Alex Wilson
 */
public abstract class FileOperator implements FileHandler {
    protected File myFile;
    
    FileOperator(File t_file) {
        this.myFile = t_file;
    }
    
    @Override
    public void setFile(File f) throws FileNotFoundException {
        if (!f.exists()) {
            throw new FileNotFoundException("No file could be found at path "+f.getAbsolutePath()+".");
        } else {
            this.myFile = f;
        }
    }
}
