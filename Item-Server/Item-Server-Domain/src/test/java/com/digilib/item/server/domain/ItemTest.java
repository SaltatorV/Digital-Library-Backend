package com.digilib.item.server.domain;

import com.digilib.item.server.domain.vo.Genre;
import com.digilib.item.server.domain.vo.ItemSnapshot;
import org.junit.jupiter.api.Test;


import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemTest {

    @Test
    public void shouldInitializeItem() {
        //given
        var snapshot = prepareNotInitializedTheHobbitItem();

        //when
        var item = Item.initializeItem(snapshot);

        //then
        assertNotNull(item.createSnapshot().getId());
    }

    @Test
    public void shouldCreateSnapshot() {
        //given
        var expected = prepareNotInitializedTheHobbitItem();
        var item = Item.initializeItem(expected);

        //when
        var snapshot = item.createSnapshot();

        //then
        assertNotNull(snapshot.getId());
        assertEquals(expected.getIsbn(), snapshot.getIsbn());
    }

    private ItemSnapshot prepareNotInitializedTheHobbitItem() {
        return new ItemSnapshot("978-0547928227", "Fantasy" ,"The Hobbit: Or There and Back Again",
                "J.R.R. Tolkien", "William Morrow & Company", Date.valueOf("2012-10-18"));
    }
}
