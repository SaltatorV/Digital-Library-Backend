package com.digilib.item.server.domain.vo;

public enum Genre {
    FICTION("Fiction"),
    NON_FICTION("Non-Fiction"),
    MYSTERY("Mystery"),
    THRILLER("Thriller"),
    ROMANCE("Romance"),
    SCIENCE_FICTION("Science Fiction"),
    FANTASY("Fantasy"),
    HORROR("Horror"),
    BIOGRAPHY("Biography"),
    HISTORY("History");

    private final String name;

    Genre(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public static Genre createFrom(String genre) {
        return Genre.valueOf(genre.toUpperCase());
    }

}