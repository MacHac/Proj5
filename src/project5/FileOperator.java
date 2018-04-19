package project5;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * This is a generic implementation of FileHandler.  It requires that all subclasses
 * implement the function operate(), which signals the object to perform its
 * file operation.
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
