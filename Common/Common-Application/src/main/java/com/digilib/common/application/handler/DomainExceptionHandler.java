package com.digilib.common.application.handler;

import com.digilib.common.domain.exception.ErrorResponse;

public interface DomainExceptionHandler<T> {
    ErrorResponse handleException(T exception);
}
