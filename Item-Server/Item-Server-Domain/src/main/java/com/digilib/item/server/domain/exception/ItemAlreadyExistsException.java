package com.digilib.item.server.domain.exception;

public class ItemAlreadyExistsException extends ItemServerDomainException {
    private ItemAlreadyExistsException(String isbn) {
        super(String.format("The item with the corresponding ISBN: %s already exists.", isbn));
    }

    public static ItemAlreadyExistsException createForIsbn(String isbn) {
        return new ItemAlreadyExistsException(isbn);
    }
}
