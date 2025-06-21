package org.example.Shop.Exceptions;

public class NotWorkHoursException extends RuntimeException {
    public NotWorkHoursException() {
        super();
    }

    public NotWorkHoursException(String message) {
        super(message);
    }

    public NotWorkHoursException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotWorkHoursException(Throwable cause) {
        super(cause);
    }

    protected NotWorkHoursException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
