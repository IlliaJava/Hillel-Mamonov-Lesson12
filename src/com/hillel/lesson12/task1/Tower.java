package com.hillel.lesson12.task1;

public class Tower extends Unit {

    public Tower(int[] coordinates) {
        super(coordinates);
        this.setIsDestroyable(false);
        this.setUnitType("Tower");
    }
}
