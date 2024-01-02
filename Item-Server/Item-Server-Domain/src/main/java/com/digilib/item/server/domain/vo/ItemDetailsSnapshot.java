package com.digilib.item.server.domain.vo;

public class ItemDetailsSnapshot {
    private String itemId;
    private String description;
    private String binding;
    private Artwork artwork;

    public String getItemId() {
        return itemId;
    }

    public String getDescription() {
        return description;
    }

    public String getBinding() {
        return binding;
    }

    public Artwork getArtwork() {
        return artwork;
    }
}
