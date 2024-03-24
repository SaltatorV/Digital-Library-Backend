package com.digilib.item.server.domain.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;

@Getter
@EqualsAndHashCode
public class ItemSnapshot {
    private String id;
    private final String isbn;
    private final String genre;
    private final String title;
    private final String author;
    private final String publisher;
    private final Date releaseDate;

    public ItemSnapshot(String id, String isbn, String genre, String title, String author, String publisher, Date releaseDate) {
        this(isbn, genre, title, author, publisher, releaseDate);
        this.id = id;
    }

    public ItemSnapshot(String isbn, String genre, String title, String author, String publisher, Date releaseDate) {
        this.isbn = isbn;
        this.genre = genre;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
    }
}
