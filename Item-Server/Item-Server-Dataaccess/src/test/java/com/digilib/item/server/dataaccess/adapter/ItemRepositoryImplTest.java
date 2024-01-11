package com.digilib.item.server.dataaccess.adapter;

import com.digilib.item.server.dataaccess.entity.ItemEntity;
import com.digilib.item.server.dataaccess.mapper.ItemDatabaseMapper;
import com.digilib.item.server.dataaccess.repository.ItemJpaRepository;
import com.digilib.item.server.domain.vo.ItemSnapshot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ItemRepositoryImplTest {

    @Mock
    private ItemJpaRepository itemJpaRepository;
    @Mock
    private ItemDatabaseMapper mapper;

    @InjectMocks
    private ItemRepositoryImpl repository;

    @Test
    public void shouldSaveItemSnapshot() {
        //given
        var snapshot = prepareTheHobbitSnapshot();
        var entity = mapItemSnapshotToEntity(snapshot);

        doReturn(entity)
                .when(mapper)
                        .mapItemSnapshotToEntity(snapshot);

        //when
        repository.save(snapshot);

        //then
        verify(itemJpaRepository, times(1))
                .save(entity);
    }

    @Test
    public void shouldFindItemByISBN (){
        //given
        var expected = prepareTheHobbitSnapshot();
        var entity = mapItemSnapshotToEntity(expected);

        doReturn(Optional.of(entity))
                .when(itemJpaRepository)
                .findByIsbn(expected.getIsbn());

        doReturn(expected)
                .when(mapper)
                .mapItemEntityToSnapshot(any());

        //when
        var response = repository.findByISBN(expected.getIsbn());

        //then
        assertEquals(expected, response.get());
    }

    @Test
    public void shouldReturnTrueWhenExistByIsbn() {
        //given
        var isbn = "978-0547928227";

        doReturn(true)
                .when(itemJpaRepository)
                .existsByIsbn(isbn);

        //when
        var response = repository.existsByISBN(isbn);

        //then
        assertTrue(response);
    }

    @Test
    public void shouldReturnFalseWhenExistByIsbn() {
        //given
        var isbn = "978-0547928227";

        doReturn(false)
                .when(itemJpaRepository)
                .existsByIsbn(isbn);

        //when
        var response = repository.existsByISBN(isbn);

        //then
        assertFalse(response);
    }
    private ItemSnapshot prepareTheHobbitSnapshot() {
        return new ItemSnapshot(UUID.randomUUID().toString(), "978-0547928227", "The Hobbit: Or There and Back Again", "Fantasy",
                "J.R.R. Tolkien", "William Morrow & Company", Date.valueOf("2012-10-18"));
    }

    private ItemEntity mapItemSnapshotToEntity(ItemSnapshot snapshot) {
        return ItemEntity
                .builder()
                .itemId(snapshot.getId())
                .isbn(snapshot.getIsbn())
                .title(snapshot.getTitle())
                .genre(snapshot.getGenre())
                .author(snapshot.getAuthor())
                .publisher(snapshot.getPublisher())
                .releaseDate(snapshot.getReleaseDate())
                .build();
    }
}
