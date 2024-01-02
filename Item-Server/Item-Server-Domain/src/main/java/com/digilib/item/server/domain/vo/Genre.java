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

    private final String displayName;

    Genre(String displayName) {
        this.displayName = displayName;
    }
    public String getName() {
        return displayName;
    }


}
