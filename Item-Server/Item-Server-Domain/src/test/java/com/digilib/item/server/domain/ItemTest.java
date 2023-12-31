package com.digilib.item.server.domain;

import com.digilib.item.server.domain.vo.ItemSnapshot;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemTest {

    @Test
    public void shouldInitializeId() {
        //given
        var snapshot = createSnapshotWithValidISBN();

        //when
        var item = Item.initializeItem(snapshot);

        //then
        assertNotNull(item.createSnapshot().getId());
    }

    @Test
    public void shouldCreateSnapshot() {
        //given
        var expected = createSnapshotWithValidISBN();
        var item = Item.initializeItem(expected);

        //when
        var snapshot = item.createSnapshot();

        //then
        assertNotNull(snapshot.getId());
        assertEquals(expected.getIsbn(), snapshot.getIsbn());
    }

    private ItemSnapshot createSnapshotWithValidISBN() {
        return new ItemSnapshot("978-83-01-00000-1");
    }
}
