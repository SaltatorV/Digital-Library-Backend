package com.digilib.item.server.service.dto.command;

import java.util.Date;

public class CreateItemCommand {
    private String ISBN;
    private String genre;
    private String title;
    private String author;
    private String publisher;
    private Date releaseDate;

    public CreateItemCommand(String ISBN, String genre, String title, String author, String publisher, Date releaseDate) {
        this.ISBN = ISBN;
        this.genre = genre;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
    }

    public String getISBN() {
        return ISBN;
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
}
