package ru.skorikov;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * Класс эмулирует работу приложения.
 *
 * @ author: Alex Skorikov.
 * @ date: 05.06.17
 * @ version Stady_2.
 */

public class StartUITest {
    /**
     * Тестируем добавление новой заявки.
     *
     * @throws MenuOutException сообщение о ошибке.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() throws MenuOutException {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", " test desc", "y"});
        new StartUI(input, tracker).init();
        Assert.assertNotNull(tracker.findAll());
    }

    /**
     * Тестируем нахождение всех заявок.
     *
     * @throws MenuOutException сообщение о ошибке.
     */
    @Test
    public void whenUserAddThreeItemsThenShowThreeItems() throws MenuOutException {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desk1");
        Item item2 = new Item("name2", "desk2");
        Item item3 = new Item("name3", "desk3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        String id1 = item1.getId();
        String id2 = item2.getId();
        String id3 = item3.getId();
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker).init();

        assertEquals(tracker.findeById(id1).getName(), "name1");
        assertEquals(tracker.findeById(id2).getName(), "name2");
        assertEquals(tracker.findeById(id3).getName(), "name3");
    }

    /**
     * Тестируем удаление заявки.
     *
     * @throws MenuOutException сообщение о ошибке.
     */
    @Test
    public void whenUserDeleteItemThenDeleteItem() throws MenuOutException {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desk1");
        Item item2 = new Item("name2", "desk2");
        Item item3 = new Item("name3", "desk3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        String id = item2.getId();
        Input input = new StubInput(new String[]{"3", id, "y"});
        new StartUI(input, tracker).init();
        assertEquals(tracker.findeById(id), null);
    }

    /**
     * Тестируем изменение заявки.
     *
     * @throws MenuOutException сообщение о ошибке.
     */
    @Test
    public void whenUserEditItemThenEditItemInTracker() throws MenuOutException {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desk1");
        Item item2 = new Item("name2", "desk2");
        Item item3 = new Item("name3", "desk3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        String id = item2.getId();
        Input input = new StubInput(new String[]{"2", id, "name4", "desk4", "y"});
        new StartUI(input, tracker).init();
        assertEquals(tracker.findeById(id).getName(), "name4");
    }

    /**
     * Тестируем поиск заявки по ID.
     *
     * @throws MenuOutException сообщение о ошибке.
     */
    @Test
    public void whenUserFindItemByIDthenFoundId() throws MenuOutException {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desk1");
        Item item2 = new Item("name2", "desk2");
        Item item3 = new Item("name3", "desk3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        String id = item2.getId();
        Input input = new StubInput(new String[]{"4", id, "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findeById(id), is(item2));
    }

    /**
     * Тестируем поиск заявки по имени.
     *
     * @throws MenuOutException сообщение о ошибке.
     */
    @Test
    public void whenUserFindItenByNameThenFoundItemName() throws MenuOutException {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desk1");
        Item item2 = new Item("name2", "desk2");
        Item item3 = new Item("name3", "desk3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        String id2 = item2.getId();
        Input input = new StubInput(new String[]{"5", "name2", "y"});
        new StartUI(input, tracker).init();
        assertEquals(tracker.findeById(id2).getName(), "name2");
    }
    /**
     * Выход из программы "тестировался" в каждом тесте.
     */

}