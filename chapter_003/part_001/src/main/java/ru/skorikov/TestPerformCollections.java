package ru.skorikov;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Date;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 04.09.17
 * @ version Stady_2.
 * Пакет 1 часть 3 задание 2
 * Написать программу, которая замеряет время вставки в коллекцию
 * большого количества случайных строк и удаления в коллекции первых n элементов для:
 * LinkedList
 * ArrayList
 * TreeSet
 */

public class TestPerformCollections {
    /**
     * Коллекция типа LinkedList.
     */
    private static LinkedList<String> linkList = new LinkedList<>();
    /**
     * Коллекция типа ArrayList.
     */
    private static ArrayList<String> arrayList = new ArrayList<>();
    /**
     * Коллекция типа TreeSet.
     */
    private static TreeSet<String> treeSet = new TreeSet<>();

    /**
     * Метод запуска приложения.
     * @param args массив строк.
     */
    public static void main(String[] args) {

        System.out.print("Время добавления 1 000 000 строк в LinkedList в мсек \t");
        System.out.println(add(linkList, 1000000));
        System.out.print("Время добавления 1 000 000 строк в ArrayList в мсек \t");
        System.out.println(add(arrayList, 1000000));
        System.out.print("Время добавления 1 000 000 строк в TreeSet в мсек \t\t");
        System.out.println(add(treeSet, 1000000));
        System.out.print("Время удаления 100 000 строк из LinkedList в мсек \t\t");
        System.out.println(delete(linkList, 100000));
        System.out.print("Время удаления 100 000 строк из TreeSet в мсек \t\t\t");
        System.out.println(delete(treeSet, 100000));
        System.out.print("Время удаления 100 000 строк из ArrayList в мсек \t\t");
        System.out.println(delete(arrayList, 100000));

    }

    /** Метод добавляет в коллекцию amount строк.
     * @param collection коллекция.
     * @param amount  количество строк.
     * @return  потраченное время в миллисекундах.
     */
    public static long add(Collection<String> collection, int amount) {
        Date start = new Date();
        for (int i = 0; i < amount; i++) {
            collection.add("TempStringррррррррррррррррррррррррррррррр" + i);
        }
        Date end = new Date();
        long result = (end.getTime() - start.getTime());
        return result;
    }

    /** Метод удаляет amount первых строк из коллекции.
     * @param collection коллекция.
     * @param amount количество строк.
     * @return потрачено времени в миллисекундах.
     */
    public static long delete(Collection<String> collection, int amount) {
        Date start = new Date();
        Iterator<String> iterator = collection.iterator();
        for (int i = 0; i < amount; i++) {
            iterator.next();
            iterator.remove();
        }
        Date end = new Date();
        long result = (end.getTime() - start.getTime());
        return result;
    }

}
