package com.digilib.item.server.application.handler;


import com.digilib.common.application.handler.DomainExceptionHandler;
import com.digilib.common.domain.exception.ErrorResponse;
import com.digilib.item.server.domain.exception.ItemAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.digilib.common.domain.exception.ErrorResponse.anErrorResponse;

@ControllerAdvice
public class ItemAlreadyExistsExceptionHandler implements DomainExceptionHandler<ItemAlreadyExistsException> {

    @ResponseBody
    @ExceptionHandler(value = {ItemAlreadyExistsException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    @Override
    public ErrorResponse handleException(ItemAlreadyExistsException exception) {
        return anErrorResponse()
                .withCode(HttpStatus.CONFLICT.value())
                .withMessage(exception.getMessage())
                .build();
    }
}
