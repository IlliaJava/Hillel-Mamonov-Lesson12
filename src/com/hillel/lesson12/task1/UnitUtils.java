package com.hillel.lesson12.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UnitUtils {
    private static final Random RANDOM = new Random();

    protected static List<int[]> takenCoordinates = new ArrayList<>();

    /**
     * Генерирует уникальные координаты для высадки юнитов на карту
     * @return координаты x, y в формате массива {x,y}
     */
    protected static int[] randomCoordinate() {
        int[] coordinates = {0,0};
        coordinates[0] = RANDOM.nextInt(10) + 1;
        coordinates[1] = RANDOM.nextInt(10) + 1;
        for (int i = 1; i < takenCoordinates.size(); i++) {
            if (Arrays.equals(coordinates, takenCoordinates.get(i))) {
                randomCoordinate();
                i = 0;
            }
        }
        takenCoordinates.add(coordinates);
        return coordinates;
    }


}
