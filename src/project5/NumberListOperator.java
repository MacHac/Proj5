package project5;

import java.util.Arrays;

/**
 *
 * @author Alex Wilson
 */
public class NumberListOperator {
    protected double[] numbers;
    private double _val;
    
    NumberListOperator(double[] numbers) {
        this.numbers = numbers;
    }
    
    public double sum() {
        return Arrays.stream(numbers).sum();
    }
    
    public double average() {
        return this.sum() / numbers.length;
    }
    
    public double product() {
        return Arrays.stream(numbers).reduce(1, (a, b) -> a * b);
    }
    
    //Invalid inputs return false, indicating that it is NOT safe to use getBuffer()
    //to check the result of the operation.  Otherwise, getBuffer() will return the
    //result of the requested operation, and this function returns true.
    public boolean fromCommand(String command) {
        switch (command.toLowerCase()) {
            case "product":
                _val = product();
                return true;
            case "sum":
                _val = sum();
                return true;
            case "average":
                _val = average();
                return true;
            default:
                return false;
        }
    }
    
    public double getBuffer() {
        return this._val;
    }
}
