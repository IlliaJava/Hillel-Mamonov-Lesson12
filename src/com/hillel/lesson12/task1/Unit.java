package com.hillel.lesson12.task1;

import java.util.Arrays;

public class Unit {
    private int[] coordinates = {0, 0};
    private String unitType;
    private boolean isDestroyable = true; // возможно ли унчтожить юнита
    private int lifes; // количество жизней у юнита
    private int damage; // урон, который может наносить юнит

    public Unit(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public String getUnitType() {
        return unitType;
    }

    public boolean getIsDestroyable() {
        return isDestroyable;
    }

    public int getLifes() {
        return lifes;
    }

    public int getDamage() {
        return damage;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }


    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public void setIsDestroyable(boolean isDestroyable) {
        this.isDestroyable = isDestroyable;
    }

    public void setLifes(int lifes) {
        this.lifes = lifes;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "\nUnit{" +
                "coordinates=" + Arrays.toString(coordinates) +
                ", unitType='" + unitType + '\'' +
                '}';
    }
}
