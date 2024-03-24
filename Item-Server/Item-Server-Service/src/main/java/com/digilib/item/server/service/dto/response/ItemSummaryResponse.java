package com.digilib.item.server.service.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ItemSummaryResponse {
    private final String title;
    private final String author;
    private final String coverLink;

    public static ItemSummaryResponse create(String title, String author, String coverLink) {
        return new ItemSummaryResponse(title, author, coverLink);
    }
}
