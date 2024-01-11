package com.digilib.item.server.application.handler;

import com.digilib.common.domain.exception.ErrorResponse;
import com.digilib.item.server.domain.exception.ItemAlreadyExistsException;
import com.digilib.item.server.domain.exception.ItemNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemAlreadyExistsExceptionHandlerTest {

    private ItemAlreadyExistsExceptionHandler handler = new ItemAlreadyExistsExceptionHandler();
    private ErrorResponse response;

    @Test
    public void testHandleError() {
        //given
        ItemAlreadyExistsException exception = createItemAlreadyExistsException();

        //when
        handleException(exception);

        //then
        responseCodeIs(409);
    }

    private ItemAlreadyExistsException createItemAlreadyExistsException(){
        return new ItemAlreadyExistsException();
    }

    private void handleException(ItemAlreadyExistsException exception) {
        response = handler.handleException(exception);
    }

    private void responseCodeIs(int code) {
        Assertions.assertEquals( code, response.getCode());
    }
}
