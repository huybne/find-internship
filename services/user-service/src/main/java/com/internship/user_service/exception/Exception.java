package com.internship.user_service.exception;

import lombok.Builder;

@Builder
public class Exception extends RuntimeException {
    private int statusCode;
    private String message;

    public Exception(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
