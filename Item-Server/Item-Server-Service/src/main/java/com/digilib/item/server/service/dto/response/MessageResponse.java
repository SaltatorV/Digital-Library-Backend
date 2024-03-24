package com.digilib.item.server.service.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MessageResponse {
    private final String message;

    public static MessageResponse create(String message) {
        return new MessageResponse(message);
    }
}
