package com.digilib.item.server.application.api;

import com.digilib.item.server.service.port.input.ItemService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

public class ItemControllerTest {

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;


    @Test
    public void shouldReturnSameISBN() {
        //given
        String ISBN = createRandomISBN();
        doReturn(ISBN)
                .when(itemService)
                .findItem(ISBN);

        //when
        var response = itemController.findItem(ISBN);

        //then
        assertEquals(ISBN, response.getISBN());
    }


    private String createRandomISBN() {
        return UUID.randomUUID().toString();
    }
}
