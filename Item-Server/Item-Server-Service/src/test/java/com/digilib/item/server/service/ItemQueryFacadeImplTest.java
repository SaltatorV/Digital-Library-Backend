package com.digilib.item.server.service;

import com.digilib.item.server.domain.exception.ItemNotFoundException;
import com.digilib.item.server.domain.vo.ItemSnapshot;
import com.digilib.item.server.service.dto.command.CreateItemCommand;
import com.digilib.item.server.service.port.output.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ItemQueryFacadeImplTest {

    @Mock
    private ItemRepository itemRepository;
    @InjectMocks
    private ItemQueryFacadeImpl itemQueryService;

    @Test
    public void shouldReturnItemResponseWithSameISBN() {
        //given
        var snapshot = prepareTheHobbitSnapshot();
        doReturn(Optional.of(snapshot))
                .when(itemRepository)
                .findByISBN(snapshot.getIsbn());

        //when
        var result = itemQueryService.findItem(snapshot.getIsbn());

        //then
        assertEquals(snapshot.getIsbn(), result.getISBN());
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
        return "978-0547928227";
    }

    private ItemSnapshot prepareTheHobbitSnapshot() {
        return new ItemSnapshot(UUID.randomUUID().toString(), "978-0547928227");
    }
}