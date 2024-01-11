package com.digilib.item.server.service.dto.command;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "Command that creates a new item details in the system.")
public class CreateItemDetailsCommand {
    @Schema(description = "Quantity of items that will be available.", example = "5")
    private int quantity;
    @Schema(description = "Item cover image", example = "Byte array")
    private byte[] img;
    @Schema(description = "Width in millimeters", example = "100")
    private double width;
    @Schema(description = "Height in millimeters", example = "70")
    private double height;
    @Schema(description = "Thickness in millimeters", example = "20")
    private double thickness;
}
