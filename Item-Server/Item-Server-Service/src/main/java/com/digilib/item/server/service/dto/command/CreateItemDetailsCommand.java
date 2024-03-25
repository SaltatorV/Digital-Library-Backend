package com.digilib.item.server.service.dto.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateItemDetailsCommand {
    private int quantity;
    private String imgLink;
    private double width;
    private double height;
    private double thickness;
}
