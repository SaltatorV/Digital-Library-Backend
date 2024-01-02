package com.digilib.item.server.domain.vo;

import java.util.Date;
import java.util.Objects;

public class ItemSnapshot {
    private String id;
    private String isbn;
    private String genre;
    private String title;
    private String author;
    private String publisher;
    private Date releaseDate;

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

    public String getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemSnapshot snapshot = (ItemSnapshot) o;
        return Objects.equals(id, snapshot.id) && Objects.equals(isbn, snapshot.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn);
    }
}
