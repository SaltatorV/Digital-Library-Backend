package com.digilib.item.server.domain.vo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenreTest {

    @Test
    public void shouldReturnValidName() {
        //given
        var genre = Genre.HISTORY;

        //when
        var name = genre.getName();

        //then
        assertEquals("History", name);
    }

    @Test
    public void shouldCreateGenreFrom() {
        //given
        var name = "fantasy";

        //when
        var genre = Genre.createFrom(name);

        //then
        assertEquals(Genre.FANTASY, genre);
    }
}
