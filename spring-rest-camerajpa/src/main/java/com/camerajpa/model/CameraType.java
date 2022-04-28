package com.camerajpa.model;

public enum CameraType {
    DSLR("DSLR"),
    SLR("SLR"),
    POINT("POINT AND SHOOT"),
    MIRRORLESS("MIRROR-LESS"),
    ACTION("ACTION"),
    SURROUND("360 CAMERA");

    private String typeOfCamera;

    CameraType(String type) {
        this.typeOfCamera = type;
    }

    public String getType() {
        return typeOfCamera;
    }
}
