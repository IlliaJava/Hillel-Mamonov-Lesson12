package com.hillel.lesson12.task1;
//Task 1. Table Game with 4 units
        /*1) Есть игра в которой клетчастое поле (например размером 10x10 клеток) и юниты, в одной клетке один юнит.
        Есть 4 типа юнитов: башня, забор, содат и танк.
        - Забор ничего не делает и может быть разрушен
        - Башня ничего не делает и безсмертна
        - Солдат стреляет и двигается - у него можно вызвать методы move() и fire()
        - Танк умеет то же что и солдат, плюс еще у него есть метод reload()
        Создать классы которые соотвествует каждому юниту и использовать extends если это целесообразно. Может быть больше классов чем перечилено в задаче если нужно.
        Создать список в котором есть юниты всех типов.*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Fence fence = new Fence(UnitUtils.randomCoordinate());
        Tower tower = new Tower(UnitUtils.randomCoordinate());
        Soldier soldier = new Soldier(UnitUtils.randomCoordinate());
        Tank tank = new Tank(UnitUtils.randomCoordinate());

        List<Unit> unitsSet = new ArrayList<>();
        unitsSet.add(tower);
        unitsSet.add(fence);
        unitsSet.add(soldier);
        unitsSet.add(tank);

        System.out.println(unitsSet);

        System.out.println("\nЖелаете поиграть? y = да, n = нет");
        if (scanner.nextLine().equals("y")){
            Game.toPlayGame(unitsSet);
        }

    }
}
