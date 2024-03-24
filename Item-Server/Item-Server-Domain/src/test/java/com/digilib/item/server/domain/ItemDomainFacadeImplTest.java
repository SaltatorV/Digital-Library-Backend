package com.digilib.item.server.domain;

import com.digilib.item.server.domain.builder.ItemSnapshotBuilder;
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
        var expected = buildSnapshot()
                .withIsbn("978-0547928227")
                .withGenre("Fantasy")
                .withTitle("The Hobbit: Or There and Back Again")
                .withAuthor("J.R.R. Tolkien")
                .withPublisher("William Morrow & Company")
                .withReleaseDateInFormatDDMMYYYY("18102012")
                .create();


        //when
        var snapshot = createItem(expected);

        //then
        assertIsSnapshotInitialized(snapshot);
    }

    private ItemSnapshotBuilder buildSnapshot() {
        return ItemSnapshotBuilder.build();
    }

    private ItemSnapshot createItem(ItemSnapshot expected) {
        return facade.createItem(expected);
    }

    private void assertIsSnapshotInitialized(ItemSnapshot snapshot) {
        assertNotNull(snapshot.getId());
    }
}
