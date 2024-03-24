package com.digilib.item.server.domain;

import com.digilib.item.server.domain.builder.ItemSnapshotBuilder;
import com.digilib.item.server.domain.vo.Genre;
import com.digilib.item.server.domain.vo.ItemSnapshot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    Item item;

    @BeforeEach
    public void setup() {
        item = null;
    }

    @Test
    public void shouldInitializeItem() {
        //given
        var snapshot = buildSnapshot()
                .withIsbn("978-0547928227")
                .withGenre("Fantasy")
                .withTitle("The Hobbit: Or There and Back Again")
                .withAuthor("J.R.R. Tolkien")
                .withPublisher("William Morrow & Company")
                .withReleaseDateInFormatDDMMYYYY("18102012")
                .create();

        //when
        initializeItem(snapshot);

        //then
        assertItemIsInitialized(snapshot);
    }

    @Test
    public void shouldCreateSnapshot() {
        //given
        var expected = buildSnapshot()
                .withIsbn("978-0547928227")
                .withGenre("Fantasy")
                .withTitle("The Hobbit: Or There and Back Again")
                .withAuthor("J.R.R. Tolkien")
                .withPublisher("William Morrow & Company")
                .withReleaseDateInFormatDDMMYYYY("18102012")
                .create();

        initializeItem(expected);

        //when
        var snapshot = createSnapshot();

        //then
        assertSnapshotsAreEqual(expected, snapshot);
    }

    private ItemSnapshotBuilder buildSnapshot() {
        return ItemSnapshotBuilder.build();
    }

    private void initializeItem(ItemSnapshot snapshot) {
        item = Item.initializeItem(snapshot);
    }

    private ItemSnapshot createSnapshot() {
        return item.createSnapshot();
    }

    private void assertItemIsInitialized(ItemSnapshot snapshot) {
        assertNotNull(item.getId());
        assertEquals(Genre.valueOf(snapshot.getGenre().toUpperCase()).getName(), item.createSnapshot().getGenre());
    }

    private void assertSnapshotsAreEqual(ItemSnapshot expected, ItemSnapshot actual) {
        assertEquals(expected.getIsbn(), actual.getIsbn());
        assertEquals(expected.getGenre(), actual.getGenre());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getAuthor(), actual.getAuthor());
        assertEquals(expected.getPublisher(), actual.getPublisher());
        assertEquals(expected.getReleaseDate(), actual.getReleaseDate());

    }
}
