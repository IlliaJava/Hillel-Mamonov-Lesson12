package com.hillel.lesson12.task1;

public class Soldier extends ArmyUnit {

    public Soldier(int[] coordinates) {
        super(coordinates);
        this.setIsDestroyable(true);
        this.setUnitType("Soldier");
        this.setLifes(2);
        this.setDamage(1);
    }

}
