package com.digilib.item.server.service.dto.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
@Schema(description = "Command that creates a new item in the system.")
public class CreateItemCommand {
    @Schema(description = "ISBN item value.", example = "978-3-16-148410-0")
    private String ISBN;
    @Schema(description = "Genre of item, several species may be listed after a comma", example = "Fantasy")
    private String genre;
    @Schema(example = "The Hobbit")
    private String title;
    @Schema(example = "J.R.R. Tolkien")
    private String author;
    @Schema(example = "Publisher-X")
    private String publisher;
    @Schema(example = "2023-12-30")
    private Date releaseDate;
}
