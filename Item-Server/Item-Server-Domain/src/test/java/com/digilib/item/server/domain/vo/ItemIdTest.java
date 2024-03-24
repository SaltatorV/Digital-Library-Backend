package com.digilib.item.server.domain.vo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemIdTest {

    private ItemId itemId;

    @BeforeEach
    public void setup() {
        itemId = null;
    }

    @Test
    public void shouldGenerateId() {
        //when
        generateId();

        //then
        assertIdIsGenerated();
    }

    @Test
    public void shouldRestoreId() {
        //when
        restoreItemId("550e8400-e29b-41d4-a716-446655440000");

        //then
        assertIdIsEqualTo("550e8400-e29b-41d4-a716-446655440000");
    }

    private void generateId() {
        itemId = ItemId.generate();
    }

    private void restoreItemId(String id) {
        itemId = ItemId.restore(id);
    }

    private void assertIdIsGenerated() {
        assertNotNull(itemId);
    }

    private void assertIdIsEqualTo(String expected) {
        assertEquals(expected, itemId.getValue());
    }
}
