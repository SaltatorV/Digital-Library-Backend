package com.digilib.item.server.service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(
        description = "Default message response."
)
public class MessageResponse {
    @Schema(description = "Message content", example = "Positive or negative information.")
    private final String message;

    private MessageResponse(String message) {
        this.message = message;
    }

    public static MessageResponse create(String message) {
        return new MessageResponse(message);
    }
}
