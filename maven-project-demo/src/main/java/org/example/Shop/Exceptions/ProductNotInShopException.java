package org.example.Shop.Exceptions;

public class ProductNotInShopException extends RuntimeException {
    public ProductNotInShopException() {
        super();
    }

    public ProductNotInShopException(String message) {
        super(message);
    }

    public ProductNotInShopException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotInShopException(Throwable cause) {
        super(cause);
    }

    protected ProductNotInShopException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
