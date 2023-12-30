package com.digilib.item.server.service;

import com.digilib.item.server.service.exception.ItemNotFoundException;
import com.digilib.item.server.service.port.output.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ItemQueryServiceImplTest {

    @Mock
    private ItemRepository itemRepository;
    @InjectMocks
    private ItemQueryServiceImpl itemQueryService;

    @Test
    public void shouldReturnItemResponseWithSameISBN() {
        //given
        String ISBN = createISBN();
        doReturn(Optional.of(ISBN))
                .when(itemRepository)
                .findByISBN(ISBN);

        //when
        var result = itemQueryService.findItem(ISBN);

        //then
        assertEquals(ISBN, result.getISBN());
    }

    @Test
    public void shouldThrowExceptionWhenCannotFindItem() {
        //given
        String ISBN = createISBN();
        doReturn(Optional.empty())
                .when(itemRepository)
                .findByISBN(ISBN);

        //when
        assertThrows(ItemNotFoundException.class, () -> itemQueryService.findItem(ISBN));
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