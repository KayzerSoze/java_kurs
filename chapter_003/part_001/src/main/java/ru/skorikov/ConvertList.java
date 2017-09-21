package ru.skorikov;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 04.09.17
 * @ version Stady_2.
 * Пакет 1 часть 3 задание 3
 * Конвертация двумерного массива в ArrayList и наоборот
 */

public class ConvertList {
    /**
     * Метод конвертирует массив массивов int в List.
     *
     * @param array массив массивов.
     * @return List.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();

        for (int[] n : array) {
            for (int m : n) {
                list.add(m);
            }
        }
        return list;
    }

    /**
     * Метод конвертирует List в массив массивов типа int.
     *
     * @param list List.
     * @param rows размер массива int.
     * @return массив int[][].
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int[][] array = new int[rows][rows];
        int i = 0;
        int j = 0;
        for (int[] m : array) {
            for (int n : m) {
                if (list.size() > 0) {
                    // Проверка на null
                    if (list.get(0) != null) {
                        array[i][j] = list.get(0);
                        list.remove(0);
                        j++;
                    } else {
                        array[i][j] = 0;
                        list.remove(0);
                        j++;
                    }
                } else {
                    array[i][j] = 0;
                }
            }
            i++;
            j = 0;
        }
        return array;
    }

    public static void main(String[] args) {
        ConvertList convertList = new ConvertList();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(null);
        list.add(4);

        int[][] nums = convertList.toArray(list, 3);

        for (int[] m : nums) {
            for (int n : m) {
                System.out.println(n);
            }
        }
    }

}
