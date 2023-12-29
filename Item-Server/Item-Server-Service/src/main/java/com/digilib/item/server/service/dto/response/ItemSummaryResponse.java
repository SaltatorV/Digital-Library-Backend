package com.digilib.item.server.service.dto.response;

public class ItemSummaryResponse {
    private final String title;
    private final String author;
    private final byte[] avatar;

    private ItemSummaryResponse(String title, String author, byte[] avatar) {
        this.title = title;
        this.author = author;
        this.avatar = avatar;
    }

    public static ItemSummaryResponse create(String title, String author, byte[] avatar) {
        return new ItemSummaryResponse(title, author, avatar);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public byte[] getAvatar() {
        return avatar;
    }
}
