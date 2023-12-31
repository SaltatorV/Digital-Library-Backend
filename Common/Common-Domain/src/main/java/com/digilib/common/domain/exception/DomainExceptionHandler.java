package com.digilib.common.domain.exception;

public interface DomainExceptionHandler<T> {
    ErrorResponse handleException(T exception);
}
