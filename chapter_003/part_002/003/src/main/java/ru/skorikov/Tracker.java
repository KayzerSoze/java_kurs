package ru.skorikov;

import java.util.ArrayList;
import java.util.Iterator;
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
     * Создание массива из заявок.
     */

    private ArrayList<Item> listItems = new ArrayList<>();
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
        listItems.add(position, item);
        position++;
        return item;
    }

    /**
     * Метод редактирования заявки.
     *
     * @param id   id.
     * @param item item.
     */
    public void update(String id, Item item) {
        for (Item item1 : listItems) {
            if (item1 != null && item1.getId().equals(id)) {
                item1.setName(item.getName());
                item1.setDescription(item.getDescription());
                break;
            }
        }
    }

    /**
     * Метод удаления заявки.
     *
     * @param item item.
     */
    public void delete(Item item) {
        Iterator<Item> iterator = listItems.iterator();
        while (iterator.hasNext()) {
            Item itemN = iterator.next();
            if (item.equals(itemN)) {
                iterator.remove();
            }
        }
    }

    /**
     * Метод ищет все заявки.
     *
     * @return Массив всех найденных заявок.
     */
    public ArrayList<Item> findAll() {

        return listItems;

    }

    /**
     * Поиск заявки по имени..
     *
     * @param key ключ.
     * @return Массив найденных по имени заявок.
     */
    public ArrayList<Item> findeByName(String key) {
        ArrayList<Item> listName = new ArrayList<>();
        for (Item item : listItems) {
            if (item.getName().equals(key)) {
                listName.add(item);
            }
        }
        return listName;
    }

    /**
     * Поиск заявки по ID.
     *
     * @param id ID.
     * @return найденная заявка.
     */
    public Item findeById(String id) {
        Item result = null;
        for (Item item : listItems) {
            if (item.getId().equals(id)) {
                result = item;
            }
        }
        return result;
    }
}
