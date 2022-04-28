package com.furnapp.model;

public enum Material {
    TWOOD(1,"TEAK WOOD"),
    SWOOD(2,"SHEESHAM WOOD"),
    MWOOD(3,"MANGO WOOD"),
    PLASTIC(4,"PLASTIC"),
    FABRIC(5,"SOFT FABRIC"),
    LEATHER(6,"LEATHERITE");


    public int grade;
    public String type;

    Material(int grade, String type) {
        this.grade = grade;
        this.type = type;
    }

}
