package com.digilib.item.server.domain.builder;

import com.digilib.item.server.domain.vo.ItemSnapshot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ItemSnapshotBuilder {
    private String id;
    private String isbn;
    private String genre;
    private String title;
    private String author;
    private String publisher;
    private Date releaseDate;

    private ItemSnapshotBuilder() {

    }

    public static ItemSnapshotBuilder build() {
        return new ItemSnapshotBuilder();
    }

    public ItemSnapshotBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public ItemSnapshotBuilder withIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public ItemSnapshotBuilder withGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public ItemSnapshotBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public ItemSnapshotBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    public ItemSnapshotBuilder withPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public ItemSnapshotBuilder withReleaseDateInFormatDDMMYYYY(String date) {
        try {
            this.releaseDate = new SimpleDateFormat("ddMMyyyy").parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return this;
    }


    public ItemSnapshot create() {
        return new ItemSnapshot(id, isbn, genre, title, author, publisher, releaseDate);
    }
}
