package com.digilib.item.server.domain.vo;

import java.util.Objects;

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

    public ItemSnapshot(String isbn, String author, String title, String publisher) {
        this(isbn);
    }

    public String getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemSnapshot snapshot = (ItemSnapshot) o;
        return Objects.equals(id, snapshot.id) && Objects.equals(isbn, snapshot.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn);
    }
}
