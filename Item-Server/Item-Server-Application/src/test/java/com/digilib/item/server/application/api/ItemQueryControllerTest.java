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

        returnItemResponseWhenGetISBN(ISBN);

        //when
        var response = findItem(ISBN);

        //then
        assertISBNEquals(ISBN, response);
    }

    @Test
    public void shouldReturnListOfSummaryItems() {
        //given
        returnSummaryItems();

        //when
        var response = findItemsSummary();

        //then
        assertItemsSummarySizeIs(3, response);
    }

    private void returnItemResponseWhenGetISBN(String ISBN) {
        doReturn(createItemResponse(ISBN))
                .when(itemQueryFacade)
                .findItem(ISBN);
    }

    private void returnSummaryItems() {
        List<ItemSummaryResponse> items = createSummaryWith3Items();
        doReturn(items)
                .when(itemQueryFacade)
                .fetchItemsSummary();
    }

    private ItemResponse findItem(String ISBN) {
        return itemQueryController.findItem(ISBN);
    }

    private List<ItemSummaryResponse> findItemsSummary() {
        return itemQueryController.findItemsSummary();
    }

    private ItemResponse createItemResponse(String ISBN) {
        return ItemResponse.create(ISBN);
    }

    private void assertISBNEquals(String ISBN, ItemResponse response) {
        assertEquals(ISBN, response.getISBN());
    }

    private void assertItemsSummarySizeIs(int size, List<ItemSummaryResponse> response) {
        assertEquals(3, response.size());
    }

    private List<ItemSummaryResponse> createSummaryWith3Items() {
        return List.of(
                ItemSummaryResponse.create("Title-1", "Author-1", "exampleLink1"),
                ItemSummaryResponse.create("Title-2", "Author-2", "exampleLink2"),
                ItemSummaryResponse.create("Title-3", "Author-3", "exampleLink3")
        );
    }
}
