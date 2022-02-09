package com.hillel.lesson12.task2;
// Task 2. Reverse sentence words and make them proper case
        /*2*) Задана строка из английских слов через пробел. Написать метод который возвращает те же слова в обратном порядке.
        При этом слова изменены так что в каждом слове первая буква большая а остальные маленькие.*/

public class ReverseSentense {
    public static void main(String[] args) {
        String sentense = "London is the capital of Great Britain";

        System.out.println(sentense);
        System.out.println("\n" + reverseSentenseWords(sentense));
    }

    private static String reverseSentenseWords(String originalSentense){
        String[] splittedText = originalSentense.split(" ");
        StringBuilder text = new StringBuilder();
        for (int i = splittedText.length - 1; i >= 0; i--) {
            text.append(intoProperCase(splittedText[i])).append(" ");
        }
        return text.toString();
    }

    private static String intoProperCase(String name) {
        String firstLetter = Character.toString(name.charAt(0)).toUpperCase();
        String leftLetters = name.substring(1).toLowerCase();
        return firstLetter + leftLetters;
    }

}
