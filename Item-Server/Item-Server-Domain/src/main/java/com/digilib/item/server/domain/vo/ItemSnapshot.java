package com.digilib.item.server.domain.vo;

public class ItemSnapshot {
    private String id;
    private String isbn;

    public ItemSnapshot(String isbn) {
        this.isbn = isbn;
    }
    public ItemSnapshot(String id, String isbn) {
        this(isbn);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }
}
