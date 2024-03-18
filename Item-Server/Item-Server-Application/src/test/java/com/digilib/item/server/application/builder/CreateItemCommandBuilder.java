package com.digilib.item.server.application.builder;

import com.digilib.item.server.service.dto.command.CreateItemCommand;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateItemCommandBuilder {
    private String ISBN;
    private String genre;
    private String title;
    private String author;
    private String publisher;
    private Date releaseDate;

    private CreateItemCommandBuilder() {
    }

    public static CreateItemCommandBuilder build() {
        return new CreateItemCommandBuilder();
    }

    public CreateItemCommandBuilder withISBN(String ISBN) {
        this.ISBN = ISBN;
        return this;
    }

    public CreateItemCommandBuilder withGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public CreateItemCommandBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public CreateItemCommandBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    public CreateItemCommandBuilder withPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public CreateItemCommandBuilder withReleaseDateInFormatDDMMYYYY(String date) {
        try {
            this.releaseDate = new SimpleDateFormat("ddMMyyyy").parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public CreateItemCommand create() {
        return new CreateItemCommand(this.ISBN, this.genre, this.title, this.author, this.publisher, this.releaseDate);
    }
}