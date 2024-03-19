package com.digilib.item.server.domain.vo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemIdTest {

    @Test
    public void shouldGenerateId() {
        //when
        var id = ItemId.generate();

        //then
        assertNotNull(id.getValue());
    }

    @Test
    public void shouldRestoreId() {
        //given
        var expected = "550e8400-e29b-41d4-a716-446655440000";

        //when
        var itemId = ItemId.restore(expected);

        //then
        assertEquals(expected, itemId.getValue());
    }
}
