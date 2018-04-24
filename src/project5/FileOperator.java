package project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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
    public void run() throws FileOperationFailedException {
        try {
            this.operate();
        } catch (FileNotFoundException e) {
            throw new FileOperationFailedException("File not found.", e);        
        } catch (IOException e) {
            throw new FileOperationFailedException("An error occurred.", e);
        }
    }
    
    public abstract void operate() throws FileNotFoundException, IOException;
}
