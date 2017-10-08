package ru.skorikov;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 05.10.17
 * @ version: java_kurs
 */
public class SortedDivisionTest {
    /**
     * Проверим сортировку по возрастанию.
     */
    @Test
    public void whenSortUpOneStringThenReturnThreeStringAndSort() {
        ArrayList<String> list = new ArrayList<>();
        String str = "K2\\SK2\\SSK2";
        list.add(str);
        SortCodeDevision sortedDivision = new SortCodeDevision();

        sortedDivision.sortedCodesDivisionUp(list);
        String str1 = "K2";
        String str2 = "K2\\SK2";
        String str3 = "K2\\SK2\\SSK2";

        Assert.assertEquals(list.get(0), str1);
        Assert.assertEquals(list.get(1), str2);
        Assert.assertEquals(list.get(2), str3);
        Assert.assertEquals(list.size(), 3);
    }

    /***
     * Проверим сортировку по убыванию.
     */
    @Test
    public void whenSortDownOneStringThenReturnThreeStringAndSort() {
        ArrayList<String> list = new ArrayList<>();
        String str = "K2\\SK1\\SSK2";
        list.add(str);
        SortCodeDevision sortedDivision = new SortCodeDevision();

        sortedDivision.sortCodesDivisionDown(list);
        String str1 = "K2";
        String str2 = "K2\\SK1";
        String str3 = "K2\\SK1\\SSK2";

        Assert.assertEquals(list.get(0), str1);
        Assert.assertEquals(list.get(1), str2);
        Assert.assertEquals(list.get(2), str3);
        Assert.assertEquals(list.size(), 3);
    }
}