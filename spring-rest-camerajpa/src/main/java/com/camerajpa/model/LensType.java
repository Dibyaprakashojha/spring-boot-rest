package com.camerajpa.model;

public enum LensType {
    PRIME("PRIME"),
    ZOOM("ZOOM"),
    TELE("TELEPHOTO"),
    WIDE("WIDE-ANGLE"),
    FISH("FISH-EYE"),
    MACRO("MACRO");

    private String typeOfLens;

    LensType(String type) {
        this.typeOfLens = type;
    }

    public String getType() {
        return typeOfLens;
    }
}
