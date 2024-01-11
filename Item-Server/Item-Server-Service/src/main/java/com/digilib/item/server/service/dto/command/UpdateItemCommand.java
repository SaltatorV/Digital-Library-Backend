package com.digilib.item.server.service.dto.command;

import java.util.Date;

public class UpdateItemCommand {
    private String title;
    private String genre;
    private String author;
    private String publisher;
    private Date releaseDate;

    public UpdateItemCommand(String title, String genre, String author, String publisher, Date releaseDate) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
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
