package com.jjh.books;

public class BookException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookException() {
	}

	public BookException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookException(String message) {
		super(message);
	}

	public BookException(Throwable cause) {
		super(cause);
	}

}
