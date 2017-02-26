package ru.skorikov;

import org.hamcrest.Matcher;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**Тест класса TrackerTest
@author Alexey Skorikov
@since 31.10.2016
@version 1.0
*/

public class TrackerTest{
	@Test
	public void whenAddTipe(){
		Tracker tracker = new Tracker();
		Tipe tipe = new Tipe("tipe", "desc", 0);
		assertThat(tracker.add(tipe), is(tipe));
	}
	@Test
	public void whenEditingTipe(){
		Tracker tracker = new Tracker();
		Tipe tipe = new Tipe("tipe", "desc", 0);
		Tipe edit = new Tipe("edittipe", "editdesk", 0);
		
		tracker.add(tipe);
		edit.setId(tipe.getId());
		tracker.editing(edit);
		
		assertThat(edit.getId(), is(tipe.getId()));
		assertThat(edit.getName(), is(tipe.getName()));
		assertThat(edit.getDescription(), is(tipe.getDescription()));
		
	}
	@Test
	public void whenDeleteTipe(){
		Tracker tracker = new Tracker();
		Tipe tipe1 = new Tipe("tipe1", "desc1", 0);
		Tipe tipe2 = new Tipe("tipe2", "desc2", 0);
		tracker.add(tipe1);
		tracker.add(tipe2);
		tracker.delete(tipe2);
		
		Tipe[] result = {tipe1, null};
		assertThat(tracker.findByAll(), is(result));
	}

	@Test
	public void whenAddComment(){
		Tracker tracker = new Tracker();
		Tipe tipe = new Tipe("tipe","desc", 0);
		tracker.add(tipe);
		String comment = "Comment";
		
		tipe.setComment("Comment");
				
		assertThat(tipe.getComment(), is(comment));
		
	}
	@Test
	public void whenFindAll(){
		Tracker tracker = new Tracker();
		Tipe tipe1 = new Tipe("tipe1", "desc1", 0);
		Tipe tipe2 = new Tipe("tipe2", "desc2", 9);
		tracker.add(tipe1);
		tracker.add(tipe2);
		
		Tipe[] result = {tipe1, tipe2};
		assertThat(tracker.findByAll(), is(result));
	}
	
	@Test
	public void whenInputIdThenFindTipeById(){
		Tracker tracker = new Tracker();
		Tipe tipe = new Tipe("tipe", "desc", 0);
		tracker.add(tipe);
		String findId = tipe.getId();
		
		Tipe findTipe = tracker.findById(findId);

		assertThat(tracker.findById(findId), is(findTipe));
		
	}
	@Test
	public void whenInputNameThenFindTipeByName(){
		Tracker tracker = new Tracker();
		Tipe tipe = new Tipe("tipe", "desc", 0);
		tracker.add(tipe);
		Tipe[] result = {tipe};
		
		assertThat(tracker.findByName(tipe.getName()), is(result));
	}
	@Test
	public void whenInputDescriptionThenFindTipeByDescription(){
		Tracker tracker = new Tracker();
		Tipe tipe = new Tipe("tipe", "desc", 0);
		tracker.add(tipe);
		String findDesk = tipe.getDescription();

		Tipe[] result = {tipe};
		
		assertThat(tracker.findByDescription(findDesk), is(result));
	}
}