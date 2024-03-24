package com.digilib.item.server.dataaccess.adapter;

import com.digilib.item.server.dataaccess.builder.ItemSnapshotBuilder;
import com.digilib.item.server.domain.vo.ItemSnapshot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ItemCommandRepositoryImplTest {
    private Database db;
    private ItemCommandRepositoryImpl repository;

    @BeforeEach
    public void setup() {
        db = new Database();
        repository = new ItemCommandRepositoryImpl(db);
    }

    @Test
    public void shouldSaveItemSnapshot() {
        //given
        var snapshot = buildSnapshot()
                .withId(UUID.randomUUID().toString())
                .withIsbn("978-0547928227")
                .withGenre("Fantasy")
                .withTitle("The Hobbit: Or There and Back Again")
                .withAuthor("J.R.R. Tolkien")
                .withPublisher("William Morrow & Company")
                .withReleaseDateInFormatDDMMYYYY("18102012")
                .create();

        //when
        saveSnapshot(snapshot);


        //then
        assertSnapshotExists(snapshot);
    }

    @Test
    public void shouldDeleteItemSnapshot() {
        //given
        var snapshot = buildSnapshot()
                .withId(UUID.randomUUID().toString())
                .withIsbn("978-0547928227")
                .withGenre("Fantasy")
                .withTitle("The Hobbit: Or There and Back Again")
                .withAuthor("J.R.R. Tolkien")
                .withPublisher("William Morrow & Company")
                .withReleaseDateInFormatDDMMYYYY("18102012")
                .create();

        saveSnapshot(snapshot);

        //when
        deleteSnapshot("978-0547928227");

        //then
        assertSnapshotNotExists(snapshot);
    }

    @Test
    public void shouldUpdateSnapshot() {
        //given
        var oldSnapshot = buildSnapshot()
                .withId(UUID.randomUUID().toString())
                .withIsbn("978-0547928227")
                .withGenre("Typo")
                .withTitle("The Hobbit: Or There and Back Again")
                .withAuthor("J.R.R. Tolkien")
                .withPublisher("William Morrow & Company")
                .withReleaseDateInFormatDDMMYYYY("18102012")
                .create();

        saveSnapshot(oldSnapshot);

        var newSnapshot = buildSnapshot()
                .withId(UUID.randomUUID().toString())
                .withIsbn("978-0547928227")
                .withGenre("Fantasy")
                .withTitle("The Hobbit: Or There and Back Again")
                .withAuthor("J.R.R. Tolkien")
                .withPublisher("William Morrow & Company")
                .withReleaseDateInFormatDDMMYYYY("18102012")
                .create();

        //when
        updateSnapshot(newSnapshot);

        //then
        assertSnapshotNotExists(oldSnapshot);
        assertSnapshotExists(newSnapshot);
    }

    @Test
    public void shouldFindSnapshotByIsbn() {
        //given
        var snapshot = buildSnapshot()
                .withId(UUID.randomUUID().toString())
                .withIsbn("978-0547928227")
                .withGenre("Fantasy")
                .withTitle("The Hobbit: Or There and Back Again")
                .withAuthor("J.R.R. Tolkien")
                .withPublisher("William Morrow & Company")
                .withReleaseDateInFormatDDMMYYYY("18102012")
                .create();

        saveSnapshot(snapshot);

        //when
        var found = findSnapshot("978-0547928227");

        //then
        assertSnapshotIsFound(found);
    }

    @Test
    public void shouldNotFindSnapshotByIsbn() {
        //given

        //when
        var found = findSnapshot("978-0547928227");

        //then
        assertSnapshotIsNotFound(found);
    }

    private ItemSnapshotBuilder buildSnapshot() {
        return ItemSnapshotBuilder.build();
    }

    private void saveSnapshot(ItemSnapshot snapshot) {
        repository.save(snapshot);
    }
    private void deleteSnapshot(String isbn) {
        repository.delete(isbn);
    }
    private void updateSnapshot(ItemSnapshot snapshot) {
        repository.update(snapshot);
    }

    private Optional<ItemSnapshot> findSnapshot(String isbn) {
        return repository.findByIsbn(isbn);
    }

    private void assertSnapshotExists(ItemSnapshot snapshot) {
        assertTrue(db.snapshots.contains(snapshot));
    }

    private void assertSnapshotNotExists(ItemSnapshot snapshot) {
        assertFalse(db.snapshots.contains(snapshot));
    }

    private void assertSnapshotIsFound(Optional<ItemSnapshot> found) {
        assertTrue(found.isPresent());
    }

    private void assertSnapshotIsNotFound(Optional<ItemSnapshot> found) {
        assertTrue(found.isEmpty());
    }

}
