package com.digilib.item.server.dataaccess.adapter;

import com.digilib.item.server.dataaccess.builder.ItemSnapshotBuilder;
import com.digilib.item.server.domain.vo.ItemSnapshot;
import com.digilib.item.server.service.port.output.ItemQueryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemQueryRepositoryImplTest {

    private Database db;
    private ItemQueryRepository repository;

    @BeforeEach
    public void setup() {
        db = new Database();
        repository = new ItemQueryRepositoryImpl(db);
    }

    @Test
    public void shouldFindByISBN() {
        //given
        var toSave = buildSnapshot()
                .withId(UUID.randomUUID().toString())
                .withISBN("978-0547928227")
                .withGenre("Fantasy")
                .withTitle("The Hobbit: Or There and Back Again")
                .withAuthor("J.R.R. Tolkien")
                .withPublisher("William Morrow & Company")
                .withReleaseDateInFormatDDMMYYYY("18102012")
                .create();

        saveSnapshot(toSave);

        //when
        var snapshot = findSnapshot("978-0547928227");

        //then
        assertSnapshotsAreEqual(toSave, snapshot);
    }

    @Test
    public void shouldReturnEmptyWhenFindByISBN() {
        //given

        //when
        var snapshot = findSnapshot("978-0547928227");

        //then
        assertIsEmpty(snapshot);
    }

    private ItemSnapshotBuilder buildSnapshot() {
        return ItemSnapshotBuilder.build();
    }

    private void saveSnapshot(ItemSnapshot snapshot) {
        db.snapshots.add(snapshot);
    }

    private Optional<ItemSnapshot> findSnapshot(String ISBN) {
        return repository.findByISBN(ISBN);
    }

    private void assertSnapshotsAreEqual(ItemSnapshot expected, Optional<ItemSnapshot> actual) {
        assertEquals(expected, actual.get());
    }

    private void assertIsEmpty(Optional<ItemSnapshot> snapshot) {
        assertTrue(snapshot.isEmpty());
    }
}
