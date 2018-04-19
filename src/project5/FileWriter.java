package project5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class writes a data string to a file.  Invokers must call setData()
 * to set the data to be written before calling operate().
 * 
 * @author Alex Wilson
 */
public class FileWriter extends FileOperator {
    protected String data;

    public FileWriter(File t_file) {
        super(t_file);
    }
    
    @Override
    public void operate() throws FileNotFoundException, IOException {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(myFile))) {
            writer.write(data);
            
            writer.close();
        }
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
}
