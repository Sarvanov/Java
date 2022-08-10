package exception;

/**
 * Исключение в случае, если при делении в знаменателе ввели 0
 */
public class DivisionByZeroException extends Throwable {

    public DivisionByZeroException(String message) {
        super(message);
    }
}