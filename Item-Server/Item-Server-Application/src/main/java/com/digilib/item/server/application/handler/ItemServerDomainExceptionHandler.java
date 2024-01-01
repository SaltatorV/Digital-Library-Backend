package com.digilib.item.server.application.handler;

import com.digilib.common.application.handler.DomainExceptionHandler;
import com.digilib.common.domain.exception.ErrorResponse;
import com.digilib.item.server.domain.exception.ItemServerDomainException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.digilib.common.domain.exception.ErrorResponse.anErrorResponse;

@ControllerAdvice
public class ItemServerDomainExceptionHandler implements DomainExceptionHandler<ItemServerDomainException> {

    @ResponseBody
    @ExceptionHandler(value = {ItemServerDomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Override
    public ErrorResponse handleException(ItemServerDomainException exception) {
        return anErrorResponse()
                .withCode(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .withMessage(exception.getMessage())
                .build();
    }


}
