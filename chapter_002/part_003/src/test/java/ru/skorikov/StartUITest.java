package ru.skorikov;

import org.hamcrest.Matcher;
import org.hamcrest.core.Is;
import org.junit.Test;

import static java.awt.SystemColor.menu;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.awt.*;
import java.util.*;

/**Тест класса StartUI
@author Alexey Skorikov
@since 09.11.2016
@version 1.0
*/

public class StartUITest{


    @Test
    public void whenSelectionOneThenAddTipe(){
        Tracker tracker = new Tracker();

        StubInput input = new StubInput(new String[] {"1", "name", "description", "9", "д"});
        new StartUI(input).start(tracker);

        assertThat(tracker.findByName("name").getName(),is("name"));
    }
    @Test
    public void whenSelectTwoThenEditTipe(){
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        tracker.add(tipe);
        String id = tracker.findByName("name").getId();
        StubInput input = new StubInput(new String[] {"2", id, "name2", "desc2", "9", "д"});
        new StartUI(input).start(tracker);

        assertThat(tracker.findByName("name2").getName(), is("name2"));
    }
    @Test
    public void whenSelectThreeThenDeleteTipe(){
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        tracker.add(tipe);
        String id = tracker.findByName("name").getId();

        StubInput input = new StubInput(new String[] {"3", id, "9", "д"});
        new StartUI(input).start(tracker);

        assertNull(tracker.findById(id));
    }
    @Test
    public void whenSelectFourThenAddComment(){
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        tracker.add(tipe);
        String id = tracker.findByName("name").getId();
        StubInput input = new StubInput(new String[] {"4", id, "comment", "9", "д"});
        new StartUI(input).start(tracker);

        assertThat(tracker.findById(id).getComment(), is("comment"));
    }
    @Test
    public void whenSelectFiveFindAllTipe(){
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        Tipe tipe2 = new Tipe("name2", "desc2");
        Tipe tipe3 = new Tipe("name2", "desc3");
        tracker.add(tipe);
        tracker.add(tipe2);
        tracker.add(tipe3);

        StubInput input = new StubInput(new String[] {"5", "9", "д"});
        new StartUI(input).start(tracker);

        assertNotNull(tracker.findByAll());
    }
    @Test
    public void whenSelectSixThenFindTipeById(){
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        tracker.add(tipe);
        String id = tracker.findByName("name").getId();
        StubInput input = new StubInput(new String[] {"6", id, "9", "д"});
        new StartUI(input).start(tracker);

        assertThat(tracker.findById(id).getId(),is(id));
    }
    @Test
    public void whenSelectSevenThenFindTipeByName(){
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        tracker.add(tipe);

        StubInput input = new StubInput(new String[] {"7","name", "9", "д"});
        new StartUI(input).start(tracker);

        assertThat(tracker.findByName("name").getName(), is("name"));
    }
    @Test
    public void whenSelectEightThenFindTipeByDesc(){
        Tracker tracker = new Tracker();
        Tipe tipe = new Tipe("name", "desc");
        tracker.add(tipe);

        StubInput input = new StubInput(new String[] {"8", "desc", "9", "д"});
        new StartUI(input).start(tracker);

        assertThat(tracker.findByDescription("desc").getDescription(), is("desc"));
    }
}