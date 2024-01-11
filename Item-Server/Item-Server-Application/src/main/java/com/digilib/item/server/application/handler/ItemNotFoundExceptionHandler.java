package com.digilib.item.server.application.handler;


import com.digilib.common.application.handler.DomainExceptionHandler;
import com.digilib.common.domain.exception.ErrorResponse;
import com.digilib.item.server.domain.exception.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.digilib.common.domain.exception.ErrorResponse.anErrorResponse;

@ControllerAdvice
public class ItemNotFoundExceptionHandler implements DomainExceptionHandler<ItemNotFoundException> {

    @ResponseBody
    @ExceptionHandler(value = {ItemNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @Override
    public ErrorResponse handleException(ItemNotFoundException exception) {
        return anErrorResponse()
                .withCode(HttpStatus.NOT_FOUND.value())
                .withMessage(exception.getMessage())
                .build();
    }
}
