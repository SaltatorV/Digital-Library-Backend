package com.digilib.item.server.domain.exception;

public class ItemNotFoundException extends ItemServerDomainException {
    private ItemNotFoundException(String isbn) {
        super(String.format("The item with the corresponding ISBN: %s cannot be found.", isbn));
    }

    public static ItemNotFoundException createForIsbn(String isbn) {
        return new ItemNotFoundException(isbn);
    }
}
