package com.digilib.item.server.dataaccess.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {

    @Id
    private String itemId;
    private String isbn;
    private String genre;
    private String title;
    private String author;
    private String publisher;
    private Date releaseDate;
}
