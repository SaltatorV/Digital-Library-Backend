package com.digilib.item.server.domain;

import com.digilib.item.server.domain.vo.ItemSnapshot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemDomainFacadeImplTest {

    private ItemDomainFacade facade;

    @BeforeEach
    public void setup() {
        facade = new ItemDomainFacadeImpl();
    }

    @Test
    public void shouldCreateItem() {
        //given
        var expected = createSnapshotWithValidISBN();

        //when
        var snapshot = facade.createItem(expected);

        //then
        assertEquals(expected.getIsbn(), snapshot.getIsbn());
        assertNotNull(snapshot.getId());
    }

    private ItemSnapshot createSnapshotWithValidISBN() {
        return new ItemSnapshot("978-83-01-00000-1");
    }
}
