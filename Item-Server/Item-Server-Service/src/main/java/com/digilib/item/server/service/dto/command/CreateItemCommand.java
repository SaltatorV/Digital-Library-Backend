package com.digilib.item.server.service.dto.command;

public class CreateItemCommand {
    private String ISBN;

    public CreateItemCommand(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }
}
