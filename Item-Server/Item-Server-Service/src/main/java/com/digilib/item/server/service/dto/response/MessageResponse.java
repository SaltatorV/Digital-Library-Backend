package com.digilib.item.server.service.dto.response;

public class MessageResponse {
    private final String message;

    private MessageResponse(String message) {
        this.message = message;
    }

    public static MessageResponse create(String message) {
        return new MessageResponse(message);
    }

    public String getMessage() {
        return message;
    }
}
