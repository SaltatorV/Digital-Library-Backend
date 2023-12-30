package com.digilib.item.server.application.handler;

import com.digilib.common.domain.exception.ErrorResponse;
import com.digilib.item.server.domain.exception.ItemServerDomainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemServerDomainExceptionHandlerTest {

    private ItemServerDomainExceptionHandler handler = new ItemServerDomainExceptionHandler();
    private ErrorResponse response;

    @Test
    public void testHandleError() {
        //given
        ItemServerDomainException exception = createDomainException("Example error message");

        //when
        handleException(exception);

        //then
        responseMessageIs("Example error message");
        responseCodeIs("Bad Request");
    }

    private ItemServerDomainException createDomainException(String message) {
        return new ItemServerDomainException(message);
    }

    private void handleException(ItemServerDomainException exception) {
        response = handler.handleException(exception);
    }

    private void responseMessageIs(String message) {
        Assertions.assertEquals( message, response.getMessage());
    }
    private void responseCodeIs(String code) {
        Assertions.assertEquals( code, response.getCode());
    }
}
