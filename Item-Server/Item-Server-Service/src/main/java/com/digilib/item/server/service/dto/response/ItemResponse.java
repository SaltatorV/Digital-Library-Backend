package com.digilib.item.server.service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(
        description = "Response containing all item information."
)
public class ItemResponse {
    @Schema(description = "ISBN item value.", example = "978-3-16-148410-0")
    private final String ISBN;

    private ItemResponse(String ISBN) {
        this.ISBN = ISBN;
    }

    public static  ItemResponse create(String ISBN) {
        return new ItemResponse(ISBN);
    }
}
