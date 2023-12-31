package com.digilib.item.server.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemTest {

    @Test
    public void shouldCreateSnapshot() {
        //given
        var item = new Item();

        //when
        var snapshot = item.createSnapshot();

        //then
        assertNotNull(snapshot);
        assertNotNull(snapshot.getId());
    }

    @Test
    public void shouldInitializeId() {
        //when
        var item = new Item();

        //then
        assertNotNull(item.createSnapshot().getId());
    }

}
