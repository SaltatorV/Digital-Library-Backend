package com.digilib.item.server.application.handler;

import com.digilib.common.domain.exception.ErrorResponse;
import com.digilib.item.server.domain.exception.ItemNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemNotFoundExceptionHandlerTest {

    private ItemNotFoundExceptionHandler handler = new ItemNotFoundExceptionHandler();
    private ErrorResponse response;

    @Test
    public void testHandleError() {
        //given
        ItemNotFoundException exception = createItemNotFoundException();

        //when
        handleException(exception);

        //then
        responseCodeIs(404);
    }

    private ItemNotFoundException createItemNotFoundException(){
        return new ItemNotFoundException();
    }

    private void handleException(ItemNotFoundException exception) {
        response = handler.handleException(exception);
    }

    private void responseCodeIs(int code) {
        Assertions.assertEquals( code, response.getCode());
    }
}
