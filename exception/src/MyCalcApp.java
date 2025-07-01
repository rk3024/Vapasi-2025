/**
 * This class accepts a number from the user and passes that to calDouble() method
 */
public class MyCalcApp {
    public static void main(String[] args) {
        if(args != null && args.length>0){
            try{
                int num = Integer.parseInt(args[0]);
                Calculator calculator = new Calculator();
                double doubleValue = calculator.calDouble(num);
                System.out.println("Double value returned is " + doubleValue);
            }catch(MyArithException maex){
                System.out.println("Number less than or equal to zero encountered" + maex.getMessage());
            }

        }
    }
}
