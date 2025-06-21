package org.example.Shop.Exceptions;

public class PersonNotInShopException extends RuntimeException {
    public PersonNotInShopException() {
        super();
    }

    public PersonNotInShopException(String message) {
        super(message);
    }

    public PersonNotInShopException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonNotInShopException(Throwable cause) {
        super(cause);
    }

    protected PersonNotInShopException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
