package com.digilib.item.server.application.api;

import com.digilib.item.server.service.port.input.ItemQueryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

public class ItemQueryControllerTest {

    @Mock
    private ItemQueryService itemQueryService;

    @InjectMocks
    private ItemQueryController itemQueryController;


    @Test
    public void shouldReturnSameISBN() {
        //given
        String ISBN = createRandomISBN();
        doReturn(ISBN)
                .when(itemQueryService)
                .findItem(ISBN);

        //when
        var response = itemQueryController.findItem(ISBN);

        //then
        assertEquals(ISBN, response.getISBN());
    }


    private String createRandomISBN() {
        return UUID.randomUUID().toString();
    }
}
