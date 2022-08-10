package exception;

/**
 * Исключение в случае неверно введенного математического действия
 */
public class BadActionValue extends Throwable {

    public BadActionValue (String message){
        super(message);
    }
}