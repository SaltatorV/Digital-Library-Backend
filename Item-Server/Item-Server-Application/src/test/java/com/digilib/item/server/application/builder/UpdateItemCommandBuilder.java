package com.digilib.item.server.application.builder;

import com.digilib.item.server.service.dto.command.UpdateItemCommand;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateItemCommandBuilder {
    private String genre;
    private String title;
    private String author;
    private String publisher;
    private Date releaseDate;

    private UpdateItemCommandBuilder() {
    }

    public static UpdateItemCommandBuilder build() {
        return new UpdateItemCommandBuilder();
    }

    public UpdateItemCommandBuilder withGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public UpdateItemCommandBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public UpdateItemCommandBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    public UpdateItemCommandBuilder withPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public UpdateItemCommandBuilder withReleaseDateInFormatDDMMYYYY(String date) {
        try {
            this.releaseDate = new SimpleDateFormat("ddMMyyyy").parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public UpdateItemCommand create() {
        return new UpdateItemCommand(this.title, this.genre, this.author, this.publisher, this.releaseDate);
    }
}