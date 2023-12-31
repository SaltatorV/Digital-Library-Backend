package com.digilib.item.server.domain.vo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemIdTest {

    @Test
    public void shouldGenerateId() {
        //when
        var id = ItemId.generate();

        //then
        assertNotNull(id.getId());
    }
}
