/**
 * MyArithException is the exception class that throws Custom Exception when
 * the client encounters numbers less than or equal to 0
 */
public class MyArithException extends RuntimeException{
    MyArithException(String message){
        super(message);
    }
}
