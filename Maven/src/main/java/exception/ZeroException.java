package exception;

/**
 * Исключение, если пользователь пытается разделить на ноль
 */
public class ZeroException extends Throwable {
    public ZeroException(String message) {
        super(message);
    }
}
