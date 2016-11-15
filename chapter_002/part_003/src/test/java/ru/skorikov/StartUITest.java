package ru.skorikov;
/**
 * Тест класса StartUI.
 *
 * @author Alexey Skorikov
 * @version 1.0
 * @since 09.11.2016
 */

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирует возможное поведение пользователя.
 */

public class StartUITest {
    /**
     *Выбор элемента 1.
     */
    @Test
    public void whenSelectionOneThenAddTipe() {
        Tracker tracker = new Tracker();
        StubInput input = new StubInput(new String[]
                {"1", "name", "description", "9", "д"});
        new StartUI(input).start(tracker);
        assertThat(tracker.findByName("name").getName(), is("name"));
    }

    /**
     *Выбор элемента 2.
     */
    @Test
    public void whenSelectTwoThenEditTipe() {
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        tracker.add(tipe);
        String id = tracker.findByName("name").getId();
        StubInput input = new StubInput(new String[]
                {"2", id, "name2", "desc2", "9", "д"});
        new StartUI(input).start(tracker);
        assertThat(tracker.findByName("name2").getName(), is("name2"));
    }

    /**
     *Выбор элемента 3.
     */
    @Test
    public void whenSelectThreeThenDeleteTipe() {
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        tracker.add(tipe);
        String id = tracker.findByName("name").getId();
        StubInput input = new StubInput(new String[]{"3", id, "9", "д"});
        new StartUI(input).start(tracker);
        assertNull(tracker.findById(id));
    }

    /**
     *Выбор элемента 4.
     */
    @Test
    public void whenSelectFourThenAddComment() {
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        tracker.add(tipe);
        String id = tracker.findByName("name").getId();
        StubInput input = new StubInput(new String[]
                {"4", id, "comment", "9", "д"});
        new StartUI(input).start(tracker);
        assertThat(tracker.findById(id).getComment(), is("comment"));
    }

    /**
     *Выбор элемента 5.
     */
    @Test
    public void whenSelectFiveFindAllTipe() {
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        Tipe tipe2 = new Tipe("name2", "desc2");
        Tipe tipe3 = new Tipe("name2", "desc3");
        tracker.add(tipe);
        tracker.add(tipe2);
        tracker.add(tipe3);
        StubInput input = new StubInput(new String[]{"5", "9", "д"});
        new StartUI(input).start(tracker);
        assertNotNull(tracker.findByAll());
    }

    /**
     *Выбор элемента 6.
     */
    @Test
    public void whenSelectSixThenFindTipeById() {
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        tracker.add(tipe);
        String id = tracker.findByName("name").getId();
        StubInput input = new StubInput(new String[]{"6", id, "9", "д"});
        new StartUI(input).start(tracker);
        assertThat(tracker.findById(id).getId(), is(id));
    }

    /**
     *Выбор элемента 7.
     */
    @Test
    public void whenSelectSevenThenFindTipeByName() {
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        tracker.add(tipe);
        StubInput input = new StubInput(new String[]
                {"7", "name", "9", "д"});
        new StartUI(input).start(tracker);
        assertThat(tracker.findByName("name").getName(), is("name"));
    }

    /**
     *Выбор элемента 8.
     */
    @Test
    public void whenSelectEightThenFindTipeByDesc() {
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        tracker.add(tipe);
        StubInput input = new StubInput(new String[]
                {"8", "desc", "9", "д"});
        new StartUI(input).start(tracker);
        assertThat(tracker.findByDescription("desc").
                getDescription(), is("desc"));
    }
}