package com.digilib.item.server.domain;

import com.digilib.item.server.domain.vo.ItemSnapshot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;

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
        var expected = prepareNotInitializedTheHobbitItem();

        //when
        var snapshot = facade.createItem(expected);

        //then
        assertEquals(expected.getIsbn(), snapshot.getIsbn());
        assertNotNull(snapshot.getId());
    }

    private ItemSnapshot prepareNotInitializedTheHobbitItem() {
        return new ItemSnapshot("978-0547928227", "Fantasy" ,"The Hobbit: Or There and Back Again",
                "J.R.R. Tolkien", "William Morrow & Company", Date.valueOf("2012-10-18"));
    }
}
