package ru.skorikov;

import java.util.Random;

/**
 * Реализовать класс Tracker. Данный класс используется как
 * хранилище для заявок. В нем должны быть методы: добавление,
 * редактирования, удаления, получения списка всех заявок
 * и списка по фильтру.
 * На каждый метод должен быть написан тест.
 * Здесь не должно быть системы ввода вывода - ни каких System.in
 *
 * @author Alexey Skorikov
 * @version 2.0
 * @since 10.11.2016
 */
public class Tracker {
    /**
     * Размер массива в трекере.
     */
    private final int sizeTipes = 10;
    /**
     * Новый массив для хранения заявок.
     */
    private Tipe[] tipes = new Tipe[sizeTipes];
    /**
     * Cчетчик.
     */
    private int position = 0;
    /**
     * рандомное число для генерации номера.
     */
    private Random rN = new Random();

    /**
     * Генерирует номер заявки.
     *
     * @return номер
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis()
                + rN.nextInt());
    }

    /**
     * Добавить заявку.
     *
     * @param tipe новая заявка
     * @return tipe добавленная заявка
     */
    public Tipe add(Tipe tipe) {
        tipe.setDate(System.currentTimeMillis());
        tipe.setId(this.generateId());
        this.tipes[position++] = tipe;
        return tipe;
    }

    /**
     * Изменить заявку.
     *
     * @param id   номер заявки
     * @param tipe заявка
     */
    public void editing(String id, Tipe tipe) {
        for (int i = 0; i < this.position; i++) {
            if (tipes[i] != null && tipes[i].getId().equals(id)) {
                tipes[i].setName(tipe.getName());
                tipes[i].setDescription(tipe.getDescription());
            }
        }
    }

    /**
     * Удалить заявку.
     *
     * @param tipe заявка
     */
    public void delete(Tipe tipe) {
        for (int i = 0; i != this.position; i++) {
            if (tipes[i].equals(tipe)) {
                tipes[i] = null;
            }
        }
        for (int j = 0; j != this.position; j++) {
            if (tipes[j] == null) {
                for (int k = j; k != this.position;) {
                    tipes[k + 1] = tipes[k];
                    k++;
                }
            }
        }
        tipes[this.position] = null;
    }

    /**
     * Добавить комментарийк заявке.
     *
     * @param tipe    заявка
     * @param comment комментарий
     */
    public void addComment(Tipe tipe, String comment) {
        if (tipe != null) {
            tipe.setComment(comment);
        }
    }

    /**
     * Поиск всех заявок.
     *
     * @return result все заявки
     */
    public Tipe[] findByAll() {
        Tipe[] result = new Tipe[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = tipes[index];
        }
        return result;
    }

    /**
     * Ищем заявку по Id.
     *
     * @param id номер
     * @return найденная заявка
     */
    public Tipe findById(String id) {
        Tipe result = null;
        for (Tipe tipe : tipes) {
            if (tipe != null && tipe.getId().equals(id)) {
                result = tipe;
                break;
            }
        }
        return result;
    }

    /**
     * Ищем заявку по имени.
     *
     * @param name имя заявки
     * @return result найденная заявка
     */
    public Tipe findByName(String name) {
        Tipe result = null;
        for (Tipe tipe : tipes) {
            if (tipe != null && tipe.getName().contains(name)) {
                result = tipe;
                break;
            }
        }
        return result;
    }

    /**
     * Ищем заявку по описанию.
     * Поиск по описанию
     *
     * @param description описание заявки
     * @return result найденная заявка
     */
    public Tipe findByDescription(String description) {
        Tipe result = null;
        for (int i = 0; i < this.position; i++) {
            if (tipes[i] != null && tipes[i].getDescription().
                    equals(description)) {
                result = tipes[i];
                break;
            }
        }
        return result;
    }
}