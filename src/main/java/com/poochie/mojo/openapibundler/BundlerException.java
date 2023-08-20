package com.poochie.mojo.openapibundler;

public class BundlerException extends Exception {
    public BundlerException(String message) {
        super(message);
    }

    public BundlerException(String message, Throwable cause) {
        super(message, cause);
    }
}
