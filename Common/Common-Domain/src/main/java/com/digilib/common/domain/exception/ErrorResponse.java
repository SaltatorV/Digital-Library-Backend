package com.digilib.common.domain.exception;

public class ErrorResponse {
    private int code;
    private String message;

    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ErrorResponseBuilder anErrorResponse() {
        return new ErrorResponseBuilder();
    }

    public static final class ErrorResponseBuilder {
        private int code;
        private String message;

        private ErrorResponseBuilder() {
        }

        public ErrorResponseBuilder withCode(int code) {
            this.code = code;
            return this;
        }

        public ErrorResponseBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(code, message);
        }
    }
}
