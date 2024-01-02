package com.digilib.item.server.domain.vo;

public class Artwork {
    private final byte[] artwork;

    public Artwork(byte[] artwork) {
        this.artwork = artwork;
    }

    public byte[] getArtwork() {
        return artwork;
    }
}
