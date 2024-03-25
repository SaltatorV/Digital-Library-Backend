package com.digilib.item.server.service;

import com.digilib.item.server.domain.exception.ItemNotFoundException;
import com.digilib.item.server.domain.vo.ItemSnapshot;
import com.digilib.item.server.service.builder.ItemSnapshotBuilder;
import com.digilib.item.server.service.dto.response.ItemResponse;
import com.digilib.item.server.service.dto.response.ItemSummaryResponse;
import com.digilib.item.server.service.port.output.ItemQueryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ItemQueryFacadeImplTest {

    @Mock
    private ItemQueryRepository itemQueryRepository;
    @InjectMocks
    private ItemQueryFacadeImpl itemQueryService;

    @Test
    public void shouldReturnItemResponseWithSameIsbn() {
        //given
        var snapshot = buildSnapshot()
                .withRandomId()
                .withIsbn("978-0547928227")
                .withGenre("Fantasy")
                .withTitle("The Hobbit: Or There and Back Again")
                .withAuthor("J.R.R. Tolkien")
                .withPublisher("William Morrow & Company")
                .withReleaseDateInFormatDDMMYYYY("18102012")
                .create();

        returnFromRepository(snapshot);

        //when
        var result = findItem(snapshot.getIsbn());

        //then
        assertIsbnsAreEqual(snapshot.getIsbn(), result.getIsbn());
    }

    @Test
    public void shouldThrowExceptionWhenCannotFindItem() {
        //given
        String isbn = "978-0547928227";

        returnEmptyValueFromRepository(isbn);

        //when
        assertThrowsItemNotFoundException(isbn);
    }

    @Test
    public void shouldReturnListOf3SummaryItems() {
        //when
        var result = fetchSummaryItems(3);

        //then
        assertResultSizeIs(result, 3);
    }

    private ItemSnapshotBuilder buildSnapshot() {
        return ItemSnapshotBuilder.build();
    }

    private void returnFromRepository(ItemSnapshot snapshot) {
        doReturn(Optional.of(snapshot))
                .when(itemQueryRepository)
                .findByIsbn(snapshot.getIsbn());
    }

    private void returnEmptyValueFromRepository(String isbn) {
        doReturn(Optional.empty())
                .when(itemQueryRepository)
                .findByIsbn(isbn);
    }

    private ItemResponse findItem(String isbn) {
        return itemQueryService.findItem(isbn);
    }

    private List<ItemSummaryResponse> fetchSummaryItems(int size) {
        return itemQueryService.fetchItemsSummary();
    }

    private void assertIsbnsAreEqual(String expected, String actual) {
        assertEquals(expected, actual);
    }

    private void assertThrowsItemNotFoundException(String isbn) {
        assertThrows(ItemNotFoundException.class, () -> findItem(isbn));
    }

    private void assertResultSizeIs(List<ItemSummaryResponse> result, int size) {
        assertEquals(size, result.size());
    }
}