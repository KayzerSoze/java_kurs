package ru.skorikov;

import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex Skorikov.
 * @ date: 03.05.17
 * @ version Stady_2.
 * Класс Трэкер - хранилище заявок и инструмент для работы с ними.
 */
class Tracker {
    /**
     * Создание массива из 10 заявок.
     */
    private Item[] items = new Item[10];
    /**
     * Переменная индексации массива.
     */
    private int position = 0;

    /**
     * Получить значение позиции в трекере.
     *
     * @return позиция.
     */
    public int getPosition() {
        return position;
    }

    /**
     * Конструктор класса.
     */
    protected Tracker() {
    }

    /**
     * Случайная переменная для создания ID Заявки.
     */

    private static final Random RN = new Random();

    /**
     * Метод генерирует ID Заявки.
     *
     * @return ID заявки.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    /**
     * Метод добавления заявки.
     *
     * @param item item.
     * @return добавленная заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * Метод редактирования заявки.
     *
     * @param id   id.
     * @param item item.
     */
    public void update(String id, Item item) {
        for (Item item1 : items) {
            if (item1 != null && item1.getId().equals(id)) {
                item1.setName(item.getName());
                item1.setDescription(item.getDescription());
                break;
            }
        }
    }

    /**
     * Метод удаления заявки.
     * В аргументах arraycopy() передается исходный массив,
     * начальная позиция копирования в исходном массиве,
     * приёмный массив,
     * начальная позиция копирования в приёмном массиве
     * и количество копируемых элементов.
     *
     * @param item item.
     */
    public void delete(Item item) {
        for (int i = 0; i < items.length - 1; i++) {
            if (items[i] != null && items[i].equals(item)) {
                items[i] = null;
                System.arraycopy(this.items, i + 1,
                        this.items, i, this.items.length - 1 - i);
            }
        }
    }

    /**
     * Метод ищет все заявки.
     *
     * @return Массив всех найденных заявок.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, position);
    }

    /**
     * Поиск заявки по имени..
     *
     * @param key ключ.
     * @return Массив найденных по имени заявок.
     */
    public Item[] findeByName(String key) {
        int razmer = 0;
        Item[] result = new Item[this.items.length];
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                result[razmer] = item;
                razmer++;
            }
        }
        result = Arrays.copyOf(result, razmer);
        return result;
    }

    /**
     * Поиск заявки по ID.
     *
     * @param id ID.
     * @return найденная заявка.
     */
    public Item findeById(String id) {
        Item result = null;
        for (Item item : items) {
            if ((null != item) && (item.getId().equals(id))) {
                result = item;
                break;
            }
        }
        return result;
    }
}
