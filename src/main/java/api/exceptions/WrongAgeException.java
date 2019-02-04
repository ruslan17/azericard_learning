package api.exceptions;

public class WrongAgeException extends RuntimeException {

    public WrongAgeException() {
    }

    public WrongAgeException(String message) {
        super(message);
    }

    public WrongAgeException(String message, Throwable cause) {
        super(message, cause);
    }
}
