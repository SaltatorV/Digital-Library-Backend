package com.digilib.common.domain.exception;

public interface DomainExceptionHandler<T> {
    public ErrorResponse handleException(T exception);
}
