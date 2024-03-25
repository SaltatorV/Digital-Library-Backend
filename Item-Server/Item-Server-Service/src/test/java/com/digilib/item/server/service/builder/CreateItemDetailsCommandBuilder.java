package com.digilib.item.server.service.builder;

import com.digilib.item.server.service.dto.command.CreateItemDetailsCommand;

public class CreateItemDetailsCommandBuilder {

    private int quantity;
    private String imgLink;
    private double width;
    private double height;
    private double thickness;
    
    private CreateItemDetailsCommandBuilder() {}

    public static CreateItemDetailsCommandBuilder build() {
        return new CreateItemDetailsCommandBuilder();
    }

    public CreateItemDetailsCommandBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public CreateItemDetailsCommandBuilder withImgLink(String imgLink) {
        this.imgLink = imgLink;
        return this;
    }

    public CreateItemDetailsCommandBuilder withWidth(double width) {
        this.width = width;
        return this;
    }

    public CreateItemDetailsCommandBuilder withHeight(double height) {
        this.height = height;
        return this;
    }

    public CreateItemDetailsCommandBuilder withThickness(double thickness) {
        this.thickness = thickness;
        return this;
    }

    public CreateItemDetailsCommand create() {
        return new CreateItemDetailsCommand(quantity, imgLink, width, height, thickness);
    }
}
