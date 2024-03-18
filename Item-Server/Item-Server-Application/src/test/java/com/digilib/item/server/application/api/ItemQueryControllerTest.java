package com.digilib.item.server.application.api;

import com.digilib.item.server.service.dto.response.ItemResponse;
import com.digilib.item.server.service.dto.response.ItemSummaryResponse;
import com.digilib.item.server.service.port.input.ItemQueryFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ItemQueryControllerTest {

    @Mock
    private ItemQueryFacade itemQueryFacade;

    @InjectMocks
    private ItemQueryController itemQueryController;

    @Test
    public void shouldReturnSameISBN() {
        //given
        var ISBN = "978-0547928227";
        doReturn(createItemResponse(ISBN))
                .when(itemQueryFacade)
                .findItem(ISBN);

        //when
        var response = itemQueryController.findItem(ISBN);

        //then
        assertEquals(ISBN, response.getISBN());
    }

    @Test
    public void shouldReturnListOfSummaryItems() {
        //given
        List<ItemSummaryResponse> items = createSummaryWith3Items();
        doReturn(items)
                .when(itemQueryFacade)
                .fetchItemsSummary();

        //when
        var response = itemQueryController.findItemsSummary();

        //then
        assertEquals(items, response);
    }

    private String createISBN() {
        return "978-83-644-7691-4";
    }

    private ItemResponse createItemResponse(String ISBN) {
        return ItemResponse.create(ISBN);
    }

    private List<ItemSummaryResponse> createSummaryWith3Items() {
        return List.of(
                ItemSummaryResponse.create("Title-1", "Author-1", "exampleLink1"),
                ItemSummaryResponse.create("Title-2", "Author-2", "exampleLink2"),
                ItemSummaryResponse.create("Title-3", "Author-3", "exampleLink3")
        );
    }
}
