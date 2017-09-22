
package ru.skorikov;

import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * Created by Alex Skorikov on 03.05.17.
 * version Stady_2.
 */

public class TrackerTest {
    /**
     * Тест метода добавить заявку.
     */
    @Test
    public void whenAddNewItemToTracker() {
        Tracker tracker = new Tracker();
        Item item = new Item("name", "description");
        assertThat(tracker.add(item), is(item));
    }

    /**
     * Тест метода редактирование заявки.
     */
    @Test
    public void whenEditItemThenEditInTracker() {
        Tracker tracker = new Tracker();
        Item item = new Item("name", "description");
        Item edit = new Item("editname", "description2");
        tracker.add(item);
        edit.setId(item.getId());
        tracker.update(item.getId(), edit);
        assertThat(edit.getName(), is(item.getName()));
        assertThat(edit.getDescription(), is(item.getDescription()));
    }

    /**
     * Тест метода удаления заявки.
     */
    @Test
    public void whenDeleteItemFromTracker() {
        Tracker tracker = new Tracker();
        Item item = new Item("name", "desk");
        Item item1 = new Item("name1", "desk1");
        tracker.add(item);
        tracker.add(item1);
        tracker.delete(item1);
        ArrayList<Item> result = new ArrayList<>();
        result.add(item);
        Assert.assertEquals(tracker.findAll(), result);
    }

    /**
     * Тест метода поиска всех заявок.
     */
    @Test
    public void whenSearchAllItemsThenShowAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desk1");
        Item item2 = new Item("name2", "desc2");
        Item item3 = new Item("name3", "desk3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        ArrayList<Item> result = new ArrayList<>();
        result.add(item1);
        result.add(item2);
        result.add(item3);

        assertThat(tracker.findAll(), is(result));
    }

    /**
     * Тест метода поиск заявки по имени.
     */
    @Test
    public void whenSearchItemNameThenShowItemName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name2", "desk1");
        Item item2 = new Item("name2", "desc2");
        Item item3 = new Item("name3", "desk3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        ArrayList<Item> listTest = new ArrayList<>();
        listTest.add(item1);
        listTest.add(item2);
        ArrayList<Item> result = new ArrayList<>();
        result = tracker.findeByName("name2");

        Assert.assertEquals(result, listTest);
    }

    /**
     * Тест метода поиска заявки по ID.
     */
    @Test
    public void whenSearchItemIdThenShowItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name2", "desk1");
        Item item2 = new Item("name2", "desc2");
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findeById(item2.getId()), is(item2));
    }
}