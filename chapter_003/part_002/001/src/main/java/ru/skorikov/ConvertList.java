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
 * Конвертация листа массивов в один лист Integer
 */

public class ConvertList {
    /**
     * Метод конвертирует массив массивов int в List.
     *
     * @param array массив массивов.
     * @return List.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<Integer>();

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
                    array[i][j] = list.get(0);
                    list.remove(0);
                    j++;
                } else {
                    array[i][j] = 0;
                }
            }
            i++;
            j = 0;
        }
        return array;
    }

    /**
     * Метод принимает лист массивов типа int.
     * Возвращает обобщенный лист Integer.
     * @param list массивы int.
     * @return List.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<Integer>();
        for (int[] n : list) {
            for (int m : n) {
                result.add(m);
            }
        }
        return result;
    }

}
