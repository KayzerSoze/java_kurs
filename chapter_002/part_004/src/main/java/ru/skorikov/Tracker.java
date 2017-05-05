package ru.skorikov;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex Skorikov.
 * @ date: 03.05.17
 * @ version Stady_2.
 * Класс Трэкер - хранилище заявок и инструмент для работы с ними.
 */
public class Tracker {
    /**
     * Создание массива из 10 заявок.
     */
    private Item[] items = new Item[10];
    /**
     * Переменная индексации массива.
     */
    private int position = 0;
    /**
     * Случайная переменная для создания ID Заявки.
     */
    private static final Random RN = new Random();

    /**
     * Метод генерирует ID Заявки.
     *
     * @return ID заявки.
     */
    String generateId() {
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
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                this.items[i].setName(item.getName());
                this.items[i].setDescription(item.getDescription());
            }
        }
    }

    /**
     * Метод удаления заявки.
     *
     * @param item item.
     */
    public void delete(Item item) {
        for (int i = 0; i < items.length - 1; i++) {
            if (items[i] != null && items[i].equals(item)) {
                items[i] = null;
            }
        }
        for (int j = 0; j < items.length - 1; j++) {
            if (items[j] == null) {
                for (int k = j; k < items.length - 1; k++) {
                    items[k] = items[k + 1];
                }
                items[items.length - 1] = null;
            }
        }
    }

    /**
     * Метод ищет все заявки.
     *
     * @return Массив всех найденных заявок.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * Поиск заявки по имени.
     * Я понимаю что не самое лучшее решение.
     * но умнее пока не придумал.
     *
     * @param key ключ.
     * @return Массив найденных по имени заявок.
     */
    public Item[] findeByName(String key) {
        int razmer = 0;
        for (int i = 0; i < items.length - 1; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                razmer++;
            }
        }
        Item[] result = new Item[razmer];
        for (int j = 0; j < items.length - 1; j++) {
            if (items[j] != null && items[j].getName().equals(key)) {
                result[j] = items[j];
            }
        }
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
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
