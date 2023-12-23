package com.digilib.item.server.application.api;

import com.digilib.item.server.service.dto.response.ItemResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemControllerTest {

    private ItemController itemController;

    @BeforeEach
    public void setup() {
        itemController = new ItemController();
    }

    @Test
    public void shouldReturnSameISBN() {
        //given
        String ISBN = createRandomISBN();

        //when
        var response = itemController.findItem(ISBN);

        //then
        assertEquals(ISBN, response.getISBN());
    }


    private String createRandomISBN() {
        return UUID.randomUUID().toString();
    }
}
