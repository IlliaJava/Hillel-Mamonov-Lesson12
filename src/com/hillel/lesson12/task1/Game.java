package com.hillel.lesson12.task1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static final int BOARD_SIZE = 10;
    static Scanner scanner = new Scanner(System.in);

    /**
     * Непосредственно дерево игровых решений, в виде бесконечного цикла while
     * !!! корректно работает лишь для конкретного листа, в данный момент созданного в классе Main
     * @param unitsSet лист экземпляров обьектов типа Unit
     */
    public static void toPlayGame(List<Unit> unitsSet) {
        System.out.println("Добро пожаловать на поле битвы!");
        System.out.println("Обозначения: H = башня, F = забор, S = солдат, T = танк");
        displayBattleBoard(unitsSet);
        while (true) {
            System.out.println("Каким юнитом хотите управлять в этой сесии? t = танк, s = солдат");
            String player = scanner.nextLine();

            if (player.equals("t")) {
                while (true) {
                    Tank playableUnit = (Tank) unitsSet.get(3);
                    System.out.println("Какое дейcтвие? m = двигаться, f = стрелять, r = перезарядить орудие");
                    String action = scanner.nextLine();
                    switch (action) {
                        case "m" -> {
                            playableUnit.move();
                            displayBattleBoard(unitsSet);
                        }
                        case "f" -> {
                            System.out.println("Укажите цель атаки? h = башня, f = забор, s = солдат");
                            String target = scanner.nextLine();
                            switch (target) {
                                case "h" -> {
                                    playableUnit.fire(unitsSet.get(0));
                                    playableUnit.setCanFire(false);
                                }
                                case "f" -> {
                                    playableUnit.fire(unitsSet.get(1));
                                    playableUnit.setCanFire(false);
                                }
                                case "s" -> {
                                    playableUnit.fire(unitsSet.get(2));
                                    playableUnit.setCanFire(false);
                                }
                                default -> {
                                    System.out.println("Недопустимый ввод");
                                }
                            }
                            displayBattleBoard(unitsSet);
                        }
                        case "r" -> playableUnit.reload();
                        default -> {
                            System.out.println("Недопустимый ввод");
                        }
                    }
                }
            } else if (player.equals("s")) while (true) {
                {
                    Soldier playableUnit = (Soldier) unitsSet.get(2);
                    System.out.println("Какое дейcтвие? m = двигаться, f = стрелять");
                    String action = scanner.nextLine();
                    switch (action) {
                        case "m" -> {
                            playableUnit.move();
                            displayBattleBoard(unitsSet);
                        }
                        case "f" -> {
                            System.out.println("Укажите цель атаки? h = башня, f = забор, t = танк");
                            String target = scanner.nextLine();
                            switch (target) {
                                case "h" -> playableUnit.fire(unitsSet.get(0));
                                case "f" -> playableUnit.fire(unitsSet.get(1));
                                case "t" -> playableUnit.fire(unitsSet.get(3));
                                default -> {
                                    System.out.println("Недопустимый ввод");
                                }
                            }
                            displayBattleBoard(unitsSet);
                        }
                        default -> {
                            System.out.println("Недопустимый ввод");
                        }
                    }
                }
            }

        }

    }

    /**
     * Отрисовывает игровое поле 10х10 и местоположение юниов на ней
     * @param unitsSet
     */
    public static void displayBattleBoard(List<Unit> unitsSet) {
        for (int row = 1; row <= BOARD_SIZE; row++) {
            System.out.println("");
            System.out.println("-----------------------------------------");

            for (int column = 1; column <= BOARD_SIZE; column++) {
                int checker = 0;
                for (int i = 0; i < unitsSet.size(); i++) {
                    if (Arrays.equals(unitsSet.get(i).getCoordinates(), new int[]{column, BOARD_SIZE - row + 1})) {
                        System.out.print("| " + unitIcon(unitsSet.get(i)) + " ");
                        break;
                    } else {
                        checker++;
                        if (checker == unitsSet.size()) {
                            System.out.print("| " + " " + " ");
                            break;
                        }
                    }
                }
            }
            System.out.print("|");
        }
        System.out.println("");
        System.out.println("-----------------------------------------");
    }

    /**
     * Возвращает иконки юнитов для отрисовки на игровом поле
     * @param unit - ноккретный экземпляр класса Unit
     * @return - "инокну" типа String
     */
    private static String unitIcon(Unit unit) {
        switch (unit.getUnitType()) {
            case "Tower" -> {
                return "H";
            }
            case "Fence" -> {
                return "F";
            }
            case "Soldier" -> {
                return "S";
            }
            case "Tank" -> {
                return "T";
            }
        }
        return "";
    }

}
