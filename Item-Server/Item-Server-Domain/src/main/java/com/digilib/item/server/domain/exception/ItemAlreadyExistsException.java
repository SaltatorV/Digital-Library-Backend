package com.digilib.item.server.domain.exception;

public class ItemAlreadyExistsException extends ItemServerDomainException {
    public ItemAlreadyExistsException() {
        super("The item with the corresponding ISBN already exists.");
    }
}
