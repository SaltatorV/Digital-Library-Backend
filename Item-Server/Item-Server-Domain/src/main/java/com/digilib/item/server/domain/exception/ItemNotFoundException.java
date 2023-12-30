package com.digilib.item.server.domain.exception;

public class ItemNotFoundException extends ItemServerDomainException {
    public ItemNotFoundException() {
        super("The item with the corresponding ISBN cannot be found.");
    }
}
