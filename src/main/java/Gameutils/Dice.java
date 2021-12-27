package main.java.Gameutils;

import java.util.Arrays;
import java.util.Random;

public class Dice {
    public static void main(String[] args) {

        binarAndLiner();

    }

    public static int[] sortSimpleDemo() {
        //создали массив
        int[] array = new int[500];
        for (int i = 0; i < array.length; i++) {
            Random random = new Random();
            array[i] = random.nextInt(500);
        }
        // до сортировки
        System.out.println("До сортировки: " + Arrays.toString(array));

        sortArray(array);

        //после сортировки
        System.out.println("После сортировки: " + Arrays.toString(array) + '\n');
        return array;
    }

    // сортировка массива
    public static void sortArray(int[] inputSkill) {
        for (int i = 0; i < inputSkill.length - 1; i++) {
            for (int j = 0; j < inputSkill.length - i - 1; j++) {
                if (inputSkill[j] < inputSkill[j + 1]) {
                    int temp = inputSkill[j];
                    inputSkill[j] = inputSkill[j + 1];
                    inputSkill[j + 1] = temp;

                }
            }
        }
    }


    public static void binarAndLiner() {
        int search = 140;

        // Линейный
        long beforeLinearSearchSorted = System.currentTimeMillis();
        int [] generateArrayOne = sortSimpleDemo();
        int result1 = linearSearch(generateArrayOne, search);
        long afterLinearSearchSorted = System.currentTimeMillis();
        System.out.println(String.format("Время выполнения линейного поиска в отсортированном массиве: %d мс", afterLinearSearchSorted - beforeLinearSearchSorted));
        System.out.println(result1 == -1 ? "Элемент не был найден (-1)." : "Элемент был найден по индексу " + result1);


        // бинарный
        long beforeBinarySearchSorted = System.currentTimeMillis();
        int[] generateArrayTwo = sortSimpleDemo();
        int result2 = binarySearch(generateArrayTwo, search);
        long afterBinarySearchSorted = System.currentTimeMillis();
        System.out.println(String.format("Время выполнения бинарного поиска в отсортированном массиве: %d мс", afterBinarySearchSorted - beforeBinarySearchSorted));
        System.out.println(result2 == -1 ? "Элемент не был найден (-1)." : "Элемент был найден по индексу " + result2 + '\n');
        System.out.println(afterBinarySearchSorted - beforeBinarySearchSorted);

    }

    // алгоритм бинарного поиска
    public static int binarySearch(int[] inputArr, int target) {
        int left = 0;
        int right = inputArr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (inputArr[mid] == target) {
                return mid;
            }
            if(inputArr[mid] > target) {
                left = mid - 1;
            }
            if (inputArr[mid] < target) {
                right = mid +1;
            }
        }
        return -1;
    }

    // алгоритм линейного поиска
    public static int linearSearch(int[] inputArr, int target) {

        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}