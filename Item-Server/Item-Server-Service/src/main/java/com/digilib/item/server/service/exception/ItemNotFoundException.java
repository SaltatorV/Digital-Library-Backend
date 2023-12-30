package com.digilib.item.server.service.exception;

import com.digilib.common.domain.exception.DomainException;

public class ItemNotFoundException extends DomainException {
    public ItemNotFoundException() {
        super("The item with the corresponding ISBN cannot be found.");
    }
}
