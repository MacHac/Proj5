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
    
    private static class FileNameReader {
        static String getFileName(Scanner s, String prompt, boolean mustExist) {
            for (;;) {
                System.out.print(prompt);
                String name = s.next();
                
                if (mustExist) {
                    File testFile = new File(name);
                    if (!testFile.exists()) {
                        System.err.printf("Error: File %s does not exist.\n", testFile.getAbsolutePath());
                        continue;
                    }   
                }
                
                return name;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        String inFileName = FileNameReader.getFileName(s, "Enter input file path: ", true);
        String outFileName = FileNameReader.getFileName(s, "Enter output file path: ", false);
        
        NumberListOperator op;
        
        try {
            op = loadList(getData(inFileName));
        } catch (FileOperationFailedException e) {
            System.err.println(e.getMessage());
            return;
        }
        
        System.out.print("Enter the operation to perform (sum | product | average): ");
        for (;;) {
            boolean result = op.fromCommand(s.next());
            if (result) break;
            System.err.println("Please enter a valid command from the list sum, product, average.");
        }
        
        double result = op.getBuffer();
        
        FileHandler write = new FileWriter(new File(outFileName));
        write.setData(Double.toString(result));
        
        try {
            write.run();
        } catch (FileOperationFailedException e) {
            System.err.println(e.getMessage());
        }
    }
    
    private static NumberListOperator loadList(String data) throws FileOperationFailedException {
        String[] components = data.split("[\\s_:]+");
        
        if (components.length == 0 || data.length() == 0) {
            throw new FileOperationFailedException("Input file contains no data.", null);
        } else {
            double[] values = new double[components.length];
            int writeIndex = 0;
            
            for (String component : components) {
                try {
                    values[writeIndex++] = Double.parseDouble(component);
                } catch (NumberFormatException e) {
                    System.err.printf("Warning: Input file contains malformed value %s.\n", component);
                    writeIndex--;
                }
            }
            
            double[] out = Arrays.copyOfRange(values, 0, writeIndex);
            
            return new NumberListOperator(out);
        }
    }
    
    private static String getData(String fileName) throws FileOperationFailedException {
        FileHandler read = new FileReader(new File(fileName));
        
        read.run();
        
        String data = read.getData();
        
        return data;
    }
}
