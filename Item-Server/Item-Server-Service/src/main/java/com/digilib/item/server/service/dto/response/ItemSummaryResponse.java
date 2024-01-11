package com.digilib.item.server.service.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(
        description = "Response containing the main item information."
)
public class ItemSummaryResponse {
    @Schema(example = "The Hobbit")
    private final String title;
    @Schema(example = "J.R.R. Tolkiena")
    private final String author;
    @Schema(example = "https://sample.url/avatarId")
    private final byte[] avatar;

    private ItemSummaryResponse(String title, String author, byte[] avatar) {
        this.title = title;
        this.author = author;
        this.avatar = avatar;
    }

    public static ItemSummaryResponse create(String title, String author, byte[] avatar) {
        return new ItemSummaryResponse(title, author, avatar);
    }
}
