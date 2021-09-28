package com.rozbit.gifservice.enums;

public enum GifEnum {
    RICH("rich"),
    BROKE("broke"),
    RUB("RUB");

    private final String name;

    GifEnum(String name) {
        this.name = name;
    }
    public String displayName() {
        return name;
    }
}
