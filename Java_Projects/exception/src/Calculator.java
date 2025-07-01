/**
 * Calculator class that returns the double value of the integer value
 */
public class Calculator {
    //return double value in case of a non-zero positive number
    //throws MyArithException in all the other cases.
    double calDouble(int num){
        if(num == 0) throw  new MyArithException("Zero not allowed");
        if(num < 0) throw new MyArithException("Negative not allowed");

        return (double)num;
    }
}
