package com.digilib.item.server.application.builder;

import com.digilib.item.server.service.dto.command.CreateItemDetailsCommand;

public class CreateItemDetailsCommandBuilder {
    private int quantity;
    private byte[] img;
    private double width;
    private double height;
    private double thickness;

    private CreateItemDetailsCommandBuilder() {
    }

    public static CreateItemDetailsCommandBuilder build() {
        return new CreateItemDetailsCommandBuilder();
    }

    public CreateItemDetailsCommandBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public CreateItemDetailsCommandBuilder withDefaultImg() {
        this.img = new byte[]{0, 1, 0, 1, 1, 1, 1};
        return this;
    }

    public CreateItemDetailsCommandBuilder withHeight(double height) {
        this.height = height;
        return this;
    }

    public CreateItemDetailsCommandBuilder withWidth(double width) {
        this.width = width;
        return this;
    }

    public CreateItemDetailsCommandBuilder withThickness(double thickness) {
        this.thickness = thickness;
        return this;
    }

    public CreateItemDetailsCommand create() {
        return new CreateItemDetailsCommand(this.quantity, this.img, this.width, this.height, this.thickness);
    }
}