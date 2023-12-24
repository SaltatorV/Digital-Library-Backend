package com.digilib.item.server.service.dto.response;

public class ItemSummaryResponse {
    private final String title;

    private ItemSummaryResponse(String title) {
        this.title = title;
    }

    public static ItemSummaryResponse create(String title) {
        return new ItemSummaryResponse(title);
    }

    public String getTitle() {
        return title;
    }
}
