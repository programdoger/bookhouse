package com.bookproject.exception;

/**
 * Created by Administrator on 2017/2/24.
 */
public class NewException extends RuntimeException{
    public NewException() {
        super();
    }

    public NewException(String message) {
        super(message);
    }

    public NewException(String message, Throwable cause) {
        super(message, cause);
    }

    public NewException(Throwable cause) {
        super(cause);
    }

    protected NewException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
