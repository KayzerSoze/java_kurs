package ru.skorikov;

/**
 * Тест класса StartUI.
 *
 * @author Alexey Skorikov
 * @version 2.0
 * @since 20.11.2016
 */

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирует возможное поведение пользователя.
 */

public class StartUITest {
    /**
     * Выбор элемента 0.
     */
    @Test
    public void whenSelectionZeroThenAddTipe() {
        Tracker tracker = new Tracker();
        StubInput input = new StubInput(new String[]
                {"0", "name", "description", "y"});
        new StartUI(input, tracker).start();
        Tipe tipe = new Tipe(tracker.findByName("name").getName(),
                tracker.findByDescription("description").getDescription());
        assertThat(tracker.findByName("name").getName(), is(tipe.getName()));
    }

    /**
     * Выбор элемента 1.
     */
    @Test
    public void whenSelectOneThenEditTipe() {
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        tracker.add(tipe);
        String id = tracker.findByName("name").getId();
        StubInput input = new StubInput(new String[]
                {"1", id, "name2", "desc2", "y"});
        new StartUI(input, tracker).start();
        assertEquals("name2", tracker.findByName("name2").getName());
    }

    /**
     * Выбор элемента 2.
     */
    @Test
    public void whenSelectTwoThenDeleteTipe() {
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desk");
        tracker.add(tipe);
        StubInput input = new StubInput(new String[]
                {"2", tracker.findByName("name").getId(), "y"});
        new StartUI(input, tracker).start();
        assertNull(tracker.findByName("name"));
    }

    /**
     * Выбор элемента 3.
     */
    @Test
    public void whenSelectFreeThenAddComment() {
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        tracker.add(tipe);
        String id = tracker.findByName("name").getId();
        StubInput input = new StubInput(new String[]
                {"3", id, "comment", "y"});
        new StartUI(input, tracker).start();
        assertThat(tracker.findById(id).getComment(), is("comment"));
    }

    /**
     * Выбор элемента 4.
     */
    @Test
    public void whenSelectFourFindAllTipe() {
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        Tipe tipe2 = new Tipe("name2", "desc2");
        Tipe tipe3 = new Tipe("name2", "desc3");
        tracker.add(tipe);
        tracker.add(tipe2);
        tracker.add(tipe3);
        StubInput input = new StubInput(new String[]{"4", "y"});
        new StartUI(input, tracker).start();
        assertNotNull(tracker.findByAll());
    }

    /**
     * Выбор элемента 5.
     */
    @Test
    public void whenSelectFiveThenFindTipeById() {
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        tracker.add(tipe);
        String id = tracker.findByName("name").getId();
        StubInput input = new StubInput(new String[]{"5", id, "y"});
        new StartUI(input, tracker).start();
        assertThat(tracker.findById(id).getId(), is(id));
    }

    /**
     * Выбор элемента 6.
     */
    @Test
    public void whenSelectSixThenFindTipeByName() {
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        tracker.add(tipe);
        StubInput input = new StubInput(new String[]
                {"7", "name", "y"});
        new StartUI(input, tracker).start();
        assertThat(tracker.findByName("name").getName(), is("name"));
    }

    /**
     * Выбор элемента 7.
     */
    @Test
    public void whenSelectSevenThenFindTipeByDesc() {
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        tracker.add(tipe);
        StubInput input = new StubInput(new String[]
                {"7", "desc", "y"});
        new StartUI(input, tracker).start();
        assertThat(tracker.findByDescription("desc").
                getDescription(), is("desc"));
    }
}