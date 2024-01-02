package com.digilib.item.server.dataaccess.adapter;

import com.digilib.item.server.domain.vo.ItemSnapshot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemRepositoryImplTest {

    private ItemRepositoryImpl repository;

    @BeforeEach
    public void setup() {
        repository = new ItemRepositoryImpl();
    }

    @Test
    public void shouldSaveItemSnapshot() {
        //given
        var snapshot = prepareTheHobbitSnapshot();

        //when
        repository.save(snapshot);

        //then
        assertTrue(repository.existsByISBN(snapshot.getIsbn()));
    }

    @Test
    public void shouldFindItemByISBN (){
        //given
        var expected = prepareTheHobbitSnapshot();
        repository.save(expected);

        //when
        var response = repository.findByISBN(expected.getIsbn());

        //then
        assertEquals(expected, response.get());
    }

    @Test
    public void shouldReturnTrueWhenExistByIsbn() {
        //given
        var expected = prepareTheHobbitSnapshot();
        repository.save(expected);

        //when
        var response = repository.existsByISBN(expected.getIsbn());

        //then
        assertTrue(response);
    }
    private ItemSnapshot prepareTheHobbitSnapshot() {
        return new ItemSnapshot(UUID.randomUUID().toString(), "978-0547928227");
    }
}