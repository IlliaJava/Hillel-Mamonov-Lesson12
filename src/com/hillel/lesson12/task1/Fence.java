package com.hillel.lesson12.task1;

public class Fence extends Unit {

    public Fence(int[] coordinates) {
        super(coordinates);
        this.setIsDestroyable(true);
        this.setUnitType("Fence");
        this.setLifes(4);
    }
}
