package com.digilib.item.server.service.dto.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
@Getter
@AllArgsConstructor
@Schema(description = "Command that creates a new item details in the system.")
public class UpdateItemCommand {
    @Schema(example = "The Hobbit")
    private String title;
    @Schema(description = "Genre of item, several species may be listed after a comma", example = "Fantasy")
    private String genre;
    @Schema(example = "J.R.R. Tolkien")
    private String author;
    @Schema(example = "Publisher-X")
    private String publisher;
    @Schema(example = "2023-12-30")
    private Date releaseDate;
}
