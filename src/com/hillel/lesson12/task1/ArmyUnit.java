package com.hillel.lesson12.task1;

import java.util.Scanner;

public class ArmyUnit extends Unit {
    static Scanner scanner = new Scanner(System.in);
    private static boolean canFire = true; // может ли юнит стрелять в данный момент

    public ArmyUnit(int[] coordinates) {
        super(coordinates);
        this.setIsDestroyable(true);
    }

    public static boolean getCanFire() {
        return canFire;
    }

    public static void setCanFire(boolean canFire) {
        ArmyUnit.canFire = canFire;
    }

    void move() {
        System.out.println("Куда сделать шаг? w = вверх, s = вниз, d = вправо, a = влево.");
        String direction = scanner.nextLine();
        int[] temp = getCoordinates();
        switch (direction) {
            case "w" -> temp[1]++;
            case "s" -> temp[1]--;
            case "a" -> temp[0]--;
            case "d" -> temp[0]++;
            default -> {
                System.out.println("Недопустимый ввод");
            }
        }
        this.setCoordinates(temp);
    }

    /**
     * Наносит цели урон после проверок на возможность стрелять, дистанцию до цели и разрушимость цели.
     * выдает сообщения при проверках и успешной атаке.
     * @param target - конкретный экземпляр класса Unit
     */
    void fire(Unit target) {
        int[] targetCoordinates = target.getCoordinates();
        int[] shooterCoordinates = this.getCoordinates();
        if (this.getCanFire()) {
            if (isFireDistance(shooterCoordinates, targetCoordinates)) {
                if (target.getIsDestroyable()) {
                    target.setLifes(target.getLifes() - this.getDamage());
                    System.out.println("Успешная атака! Цели " + target.getUnitType() + " нанесено " + this.getDamage() + " урона!");
                    isDead(target);
                } else {
                    System.out.println("Цель неуязвима к урону");
                }
            } else {
                System.out.println("Выстрел не достиг цели из-за большого расстояния!");
            }
        } else {
            System.out.println("Нужно перезарядится!");
        }
    }

    /**
     * Проверяет дистанцию до цели для выстрела. Захардкожена дистанция = 1 клетка
     * @param shooterCoordinates координаты стрелка
     * @param targetCoordinates  координаты цели
     * @return true если цель в зоне поражения
     */
    private static boolean isFireDistance(int[] shooterCoordinates, int[] targetCoordinates) {
        if (Math.abs(targetCoordinates[0] - shooterCoordinates[0]) <= 1 && Math.abs(targetCoordinates[1] - shooterCoordinates[1]) <= 1) {
            return true;
        } else return false;
    }

    private void isDead(Unit target) {
        if (target.getLifes() <= 0) {
            System.out.println(target.getUnitType() + " yничтожен!");
            target.setCoordinates(new int[]{-1, -1});
        }
    }


}
