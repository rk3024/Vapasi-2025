import java.util.Scanner;

/**
 * This class accepts a number from the user and passes that to calDouble() method
 */
public class MyCalcApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

        try {
            Calculator calculator = new Calculator();
            double doubleValue = calculator.calDouble(number);
            System.out.println("Double value returned is " + doubleValue);
        } catch (MyArithException maex) {
            System.out.println("Number less than or equal to zero encountered" + maex.getMessage());
        }
    }
}
