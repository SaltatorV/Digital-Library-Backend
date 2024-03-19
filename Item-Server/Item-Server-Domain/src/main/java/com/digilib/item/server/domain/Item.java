package com.digilib.item.server.domain;

import com.digilib.common.domain.aggregate.AggregateRoot;
import com.digilib.item.server.domain.vo.Genre;
import com.digilib.item.server.domain.vo.ItemId;
import com.digilib.item.server.domain.vo.ItemSnapshot;

import java.util.Date;

class Item extends AggregateRoot<ItemId> {
    private final String isbn;
    private Genre genre;
    private String title;
    private String author;
    private String publisher;
    private Date releaseDate;

    public Item(ItemId id, String isbn, Genre genre, String title, String author, String publisher, Date releaseDate) {
        super(id);
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
        return new ItemSnapshot(getId(), isbn, genre.toString(), title, author, publisher, releaseDate);
    }

    private static Genre createGenre(String genre) {
        return Genre.valueOf(genre.toUpperCase());
    }
}
