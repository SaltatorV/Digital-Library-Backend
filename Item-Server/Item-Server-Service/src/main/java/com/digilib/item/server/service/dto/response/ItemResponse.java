package com.digilib.item.server.service.dto.response;

public class ItemResponse {
    private final String ISBN;

    private ItemResponse(String ISBN) {
        this.ISBN = ISBN;
    }

    public static  ItemResponse create(String ISBN) {
        return new ItemResponse(ISBN);
    }
}
