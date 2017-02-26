package ru.skorikov;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса TrackerTest.
 *
 * @author Alexey Skorikov
 * @version 1.0
 * @since 31.10.2016
 */

public class TrackerTest {
    /**
     * Тестируем добавить заявку.
     */
    @Test
    public void whenAddTipe() {
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("tipe", "desc");
        assertThat(tracker.add(tipe), is(tipe));
    }

    /**
     * Тестируем редактировать заявку.
     */
    @Test
    public void whenEditingTipe() {
        Tracker tracker = new Tracker();
        String id = tracker.generateId();
        Tipe tipe = new Tipe("tipe", "desc");
        Tipe edit = new Tipe("edittipe", "editdesk");
        tracker.add(tipe);
        edit.setId(tipe.getId());
        tracker.editing(tipe.getId(), edit);
        assertThat(edit.getName(), is(tipe.getName()));
        assertThat(edit.getDescription(),
                is(tipe.getDescription()));
    }

    /**
     * Тестируем удалить заявку.
     */
    @Test
    public void whenDeleteTipe() {
        Tracker tracker = new Tracker();
        Tipe tipe1 = new Tipe("tipe1", "desc1");
        Tipe tipe2 = new Tipe("tipe2", "desc2");
        tracker.add(tipe1);
        tracker.add(tipe2);
        tracker.delete(tipe2);
        Tipe[] result = {tipe1, null};
        assertThat(tracker.findByAll(), is(result));
    }

    /**
     * Тестируем добавить комментарий.
     */
    @Test
    public void whenAddComment() {
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("tipe", "desc");
        tracker.add(tipe);
        String comment = "Comment";
        tipe.setComment("Comment");
        assertThat(tipe.getComment(), is(comment));
    }

    /**
     * Тестируем найти все заявки.
     */
    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Tipe tipe1 = new Tipe("tipe1", "desc1");
        Tipe tipe2 = new Tipe("tipe2", "desc2");
        tracker.add(tipe1);
        tracker.add(tipe2);
        Tipe[] result = {tipe1, tipe2};
        assertThat(tracker.findByAll(), is(result));
    }

    /**
     * Тестируем найти заявку по номеру.
     */
    @Test
    public void whenInputIdThenFindTipeById() {
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("tipe", "desc");
        tracker.add(tipe);
        String findId = tipe.getId();
        Tipe findTipe = tracker.findById(findId);
        assertThat(tracker.findById(findId), is(findTipe));
    }

    /**
     * Тестируем найти заявку по имени.
     */
    @Test
    public void whenInputNameThenFindTipeByName() {
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("tipe", "desc");
        tracker.add(tipe);
        Tipe result = tipe;
        assertThat(tracker.findByName(tipe.getName()), is(result));
    }

    /**
     * Тестируем найтизаявку по описанию.
     */
    @Test

    public void whenInputDescriptionThenFindTipeByDescription() {
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("tipe", "desc");
        tracker.add(tipe);
        String findDesk = tipe.getDescription();
        Tipe result = tipe;
        assertThat(tracker.findByDescription(findDesk), is(result));
    }
}