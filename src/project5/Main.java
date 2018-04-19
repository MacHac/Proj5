package project5;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This is the main class.  It is not necessary that you create the file out.txt;
 * If the rest of the program works properly, the file will be created for you
 * in the current working directory.
 * 
 * If you're missing the file in.txt in your working directory, the program will
 * report an error.  
 * 
 * @author Alex Wilson
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        NumberListOperator op = loadList(getData());
        if (op == null) return;
        
        System.out.print("Enter the operation to perform (sum | product | average): ");
        for (;;) {
            boolean result = op.fromCommand(s.next());
            if (result) break;
            System.err.println("Please enter a valid command from the list sum, product, average.");
        }
        
        double result = op.getBuffer();
        
        FileWriter write = new FileWriter(new File("out.txt"));
        write.setData(Double.toString(result));
        
        try {
            write.operate();
        } catch (Exception e) {}
    }
    
    private static NumberListOperator loadList(String data) {
        String[] components = data.split("\\s+");
        
        if (components.length == 0 || data.length() == 0) {
            System.err.println("Error: Input file is empty or doesn't exist.");
            return null;
        } else {
            double[] values = new double[components.length];
            int writeIndex = 0;
            
            for (String component : components) {
                try {
                    values[writeIndex++] = Double.parseDouble(component);
                } catch (Exception e) {
                    System.err.printf("Warning: Input file contains malformed value %s.\n", component);
                    writeIndex--;
                }
            }
            
            double[] out = Arrays.copyOfRange(values, 0, writeIndex);
            
            return new NumberListOperator(out);
        }
    }
    
    private static String getData() {
        FileReader read = new FileReader(new File("in.txt"));
        
        try {
            read.operate();
        } catch (Exception e) { return ""; }
        
        String data = read.getData();
        
        return data;
    }
}
