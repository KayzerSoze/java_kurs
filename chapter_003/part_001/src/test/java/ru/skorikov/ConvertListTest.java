package ru.skorikov;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 04.09.17
 * @ version Stady_2.
 * Пакет 1 часть 3 задание 3
 * Класс тест.
 */
public class ConvertListTest {
    /**
     * Проверим конвертацию массива в лист.
     * @throws Exception исключение.
     */
    @Test
    public void isCreateFromArraytoList() throws Exception {
        ConvertList convertList = new ConvertList();
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}};
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            list.add(i);
        }
        List<Integer> listTest = convertList.toList(array);
        Assert.assertEquals(list, listTest);


    }

    /**
     * Проверим конвертацию листа в массив.
     * @throws Exception исключение.
     */
    @Test
    public void isCreateFromListtoArray() throws Exception {
        ConvertList convertList = new ConvertList();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            list.add(i);
        }
        int[][] arrayTest = convertList.toArray(list, 3);
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}, {0, 0, 0}};
        Assert.assertArrayEquals(array, arrayTest);

    }

}