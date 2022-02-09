package com.hillel.lesson12.task1;

public class Tank extends ArmyUnit {

    public Tank(int[] coordinates) {
        super(coordinates);
        this.setIsDestroyable(true);
        this.setUnitType("Tank");
        this.setLifes(5);
        this.setDamage(2);
    }

    void reload() {
        setCanFire(true);
        System.out.println("Орудие перезаряжено и вновь может стрелять!");
    }

}
