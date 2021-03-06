package project5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class reads a file into a string.  After calling operate(), invokers
 * should call getData() to retrieve the read data.  
 * 
 * @author Alex Wilson
 */
public class FileReader extends FileOperator {
    protected String data;

    public FileReader(File t_file) {
        super(t_file);
    }
    
    @Override
    public void operate() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new java.io.FileReader(myFile));
        StringBuilder b = new StringBuilder();
        String buffer;
        while ((buffer = reader.readLine()) != null) b.append(buffer);
        
        this.data = b.toString();
    }
    
    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
