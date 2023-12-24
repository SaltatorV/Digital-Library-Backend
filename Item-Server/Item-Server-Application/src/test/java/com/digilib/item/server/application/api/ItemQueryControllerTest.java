package com.digilib.item.server.application.api;

import com.digilib.item.server.service.dto.response.ItemResponse;
import com.digilib.item.server.service.port.input.ItemQueryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ItemQueryControllerTest {

    @Mock
    private ItemQueryService itemQueryService;

    @InjectMocks
    private ItemQueryController itemQueryController;


    @Test
    public void shouldReturnSameISBN() {
        //given
        String ISBN = createISBN();
        doReturn(createItemResponse(ISBN))
                .when(itemQueryService)
                .findItem(ISBN);

        //when
        var response = itemQueryController.findItem(ISBN);

        //then
        assertEquals(ISBN, response.getISBN());
    }


    private String createISBN() {
        return "978-83-644-7691-4";
    }

    private ItemResponse createItemResponse(String ISBN) {
        return ItemResponse.create(ISBN);
    }
}
