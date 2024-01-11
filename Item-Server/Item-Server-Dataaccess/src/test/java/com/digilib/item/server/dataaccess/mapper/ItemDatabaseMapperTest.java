package com.digilib.item.server.dataaccess.mapper;

import com.digilib.item.server.dataaccess.entity.ItemEntity;
import com.digilib.item.server.domain.vo.ItemSnapshot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ItemDatabaseMapperTest {

    private ItemDatabaseMapper mapper;

    @BeforeEach
    public void setup() {
        mapper = new ItemDatabaseMapper();
    }

    @Test
    public void shouldMapItemEntityToSnapshot() {
        //given
        var entity = createHobbitEntity();

        //when
        var snapshot = mapper.mapItemEntityToSnapshot(entity);

        //then
        assertObjectsAreConsistent(entity, snapshot);
    }

    @Test
    public void shouldMapItemSnapshotToEntity() {
        //given
        var snapshot = createHobbitSnapshot();

        //when
        var entity = mapper.mapItemSnapshotToEntity(snapshot);

        //then
        assertObjectsAreConsistent(entity, snapshot);
    }


    private ItemEntity createHobbitEntity() {
        return ItemEntity
                .builder()
                .itemId(UUID.randomUUID().toString())
                .isbn("123-123-12321")
                .title("Hobbit")
                .genre("Fantasy")
                .author("J.R.R. Tolkien")
                .publisher("Publisher-x")
                .releaseDate(Date.from(Instant.now()))
                .build();
    }

    private ItemSnapshot createHobbitSnapshot() {
        return new ItemSnapshot(UUID.randomUUID().toString(), "123-123-12321", "Fantasy",
                "Hobbit", "J.R.R. Tolkien", "Publisher-x", Date.from(Instant.now()));
    }

    private void assertObjectsAreConsistent(ItemEntity entity, ItemSnapshot snapshot) {
        assertEquals(entity.getItemId(), snapshot.getId());
        assertEquals(entity.getIsbn(), snapshot.getIsbn());
        assertEquals(entity.getAuthor(), snapshot.getAuthor());
        assertEquals(entity.getTitle(), snapshot.getTitle());
        assertEquals(entity.getPublisher(), snapshot.getPublisher());
        assertEquals(entity.getGenre(), snapshot.getGenre());
        assertEquals(entity.getReleaseDate(), snapshot.getReleaseDate());
    }
}
