package com.digilib.item.server.service.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ItemResponse {
    private final String isbn;

    public static  ItemResponse create(String isbn) {
        return new ItemResponse(isbn);
    }
}
