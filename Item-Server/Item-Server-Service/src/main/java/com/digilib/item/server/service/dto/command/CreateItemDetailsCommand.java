package com.digilib.item.server.service.dto.command;

public class CreateItemDetailsCommand {
    private int quantity;
    private byte[] img;
    private double width;
    private double height;
    private double thickness;

    public CreateItemDetailsCommand(int quantity, byte[] img, double width, double height, double thickness) {
        this.quantity = quantity;
        this.img = img;
        this.width = width;
        this.height = height;
        this.thickness = thickness;
    }

    public int getQuantity() {
        return quantity;
    }

    public byte[] getImg() {
        return img;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getThickness() {
        return thickness;
    }
}
