package com.digilib.item.server.service.dto.response;

public class ItemSummaryResponse {
    private final String title;
    private final String author;
    private final String coverLink;

    private ItemSummaryResponse(String title, String author, String coverLink) {
        this.title = title;
        this.author = author;
        this.coverLink = coverLink;
    }

    public static ItemSummaryResponse create(String title, String author, String coverLink) {
        return new ItemSummaryResponse(title, author, coverLink);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCoverLink() {
        return coverLink;
    }
}
