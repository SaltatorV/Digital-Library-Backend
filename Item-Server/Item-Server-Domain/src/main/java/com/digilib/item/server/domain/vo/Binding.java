package com.digilib.item.server.domain.vo;

public enum Binding {
    HARDCOVER("Hardcover"),
    SOFTCOVER("Softcover");

    private final String type;
    Binding(String name) {
        this.type = name;
    }
    public String getType() {
        return type;
    }
}
