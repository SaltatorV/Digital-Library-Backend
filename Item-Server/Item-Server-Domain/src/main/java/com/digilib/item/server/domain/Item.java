package com.digilib.item.server.domain;

import com.digilib.item.server.domain.vo.Genre;
import com.digilib.item.server.domain.vo.ItemId;
import com.digilib.item.server.domain.vo.ItemSnapshot;

import java.util.Date;

class Item {
    private final ItemId id;
    private final String isbn;
    private Genre genre;
    private String title;
    private String author;
    private String publisher;
    private Date releaseDate;

    public Item(ItemId id, String isbn, Genre genre, String title, String author, String publisher, Date releaseDate) {
        this.id = id;
        this.isbn = isbn;
        this.genre = genre;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
    }

    public static Item initializeItem(ItemSnapshot snapshot) {
        return new Item(ItemId.generate(), snapshot.getIsbn(), createGenre(snapshot.getGenre()),
                snapshot.getTitle(), snapshot.getAuthor(), snapshot.getPublisher(), snapshot.getReleaseDate());
    }

    public ItemSnapshot createSnapshot() {
        return new ItemSnapshot(id.getId(), isbn, genre.toString(), title, author, publisher, releaseDate);
    }

    private static Genre createGenre(String genre) {
        return Genre.valueOf(genre.toUpperCase());
    }
}
