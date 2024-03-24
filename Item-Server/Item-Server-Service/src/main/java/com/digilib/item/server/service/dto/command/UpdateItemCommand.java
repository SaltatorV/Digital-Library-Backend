package com.digilib.item.server.service.dto.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class UpdateItemCommand {
    private String title;
    private String genre;
    private String author;
    private String publisher;
    private Date releaseDate;
}
