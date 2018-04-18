package com.micetr0.mock_DB;

public class PersistanceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PersistenceException(String msg) {
        super(msg);
    }

    public PersistenceException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
