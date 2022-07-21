package exception;

/**
 * Исключение в случае, если ввели не целое число
 */
public class BadIntValue extends Exception {

    public BadIntValue(String message) {
        super(message);
    }
}