package com.digilib.item.server.service;

import com.digilib.item.server.service.port.input.ItemQueryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemQueryServiceImplTest {

    private ItemQueryService itemQueryService;

    @BeforeEach
    public void setup(){
        itemQueryService = new ItemQueryServiceImpl();
    }

    @Test
    public void shouldReturnItemResponseWithSameISBN() {
        //given
        String ISBN = createISBN();

        //when
        var result = itemQueryService.findItem(ISBN);

        //then
        assertEquals(ISBN, result.getISBN());
    }

    @Test
    public void shouldReturnListOf3SummaryItems() {
        //when
        var result = itemQueryService.fetchItemsSummary();

        //then
        assertEquals(3, result.size());
    }

    public String createISBN() {
        return "0-061-96436-0";
    }
}