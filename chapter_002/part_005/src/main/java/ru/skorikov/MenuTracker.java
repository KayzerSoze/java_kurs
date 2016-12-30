package ru.skorikov;

/**
 * Класс Меню.
 *
 * @author Alexey Skorikov
 * @version 1.0
 * @since 20.11.2016
 */
public class MenuTracker {
    /**
     * interface Input.
     */
    private Input input;
    /**
     * New instance of the class Tracker.
     */
    private Tracker tracker;
    /**
     * Размер массива внутренних классов.
     */
    static final int RAZMER = 8;
    /**
     * New instance of the class UserAction.
     */
    private UserAction[] actions = new UserAction[RAZMER];

    /**
     * New instance of the class MenuTracker.
     *
     * @param atInput   ввод
     * @param atTracker трекер
     */
    public MenuTracker(Input atInput, Tracker atTracker) {
        this.input = atInput;
        this.tracker = atTracker;
    }

    /**
     * Меню из массива внутренних классов.
     */
    public void fillActions() {
        this.actions[0] = new AddTipe();
        this.actions[1] = new EditTipe();
        this.actions[2] = new DeleteTipe();
        this.actions[3] = new AddComment();
        this.actions[4] = new ShowAllTipes();
        this.actions[5] = new FindById();
        this.actions[6] = new FindByName();
        this.actions[7] = new FindByDescription();
    }

    /**
     * Выбор элемента меню.
     *
     * @param key ключ
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Отображение меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            System.out.println(action.info());
        }
    }

    /**
     * Внутренний класс - добавить заявку.
     */
    private class AddTipe implements UserAction {
        /**
         * Если выбран ключ 0.
         *
         * @return 0
         */
        public int key() {
            return 0;
        }

        /**
         * Метод класса.
         *
         * @param atInput   ввод
         * @param atTracker трекер
         */
        public void execute(Input atInput, Tracker atTracker) {
        if(tracker.getPosition() != 3){
           	String name = input.ask("Введите имя заявки :");
            String description = input.ask("Введите описание заявки:");
            tracker.add(new Tipe(name, description));
        }else{
        	System.out.println("Список заявок полон.");
        }
        	           
        }

        /**
         * 1-й элемент меню на экране.
         *
         * @return строка.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new Tipe.");
        }
    }

    /**
     * Класс Редактировать заявку.
     */
    private class EditTipe implements UserAction {
        /**
         * Если выбран ключ 1.
         *
         * @return 1
         */
        public int key() {
            return 1;
        }

        /**
         * Метод класса.
         *
         * @param atInput ввод
         * @param atTracker трекер
         */
        public void execute(Input atInput, Tracker atTracker) {
            String id = input.ask("Введите номер заявки :");
            if (tracker.findById(id) != null) {
            	String name = input.ask("Введите имя заявки :");
                String description = input.ask("Введите описание заявки:");
                Tipe tipe = new Tipe(name, description);
                tracker.editing(id, tipe);
                System.out.println("Заявка изменена.");
			}else{
				System.out.println("Заявка не найдена.");
			}
            
        }

        /**
         * 2-й элемент меню на экране.
         *
         * @return строка
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Edit Tipe.");
        }
    }

    /**
     * Класс удалить заявку.
     */
    private class DeleteTipe implements UserAction {
        /**
         * Если выбран ключ 2.
         *
         * @return 2
         */
        public int key() {
            return 2;
        }

        /**
         * Метод класса.
         *
         * @param atInput ввод
         * @param atTracker трекер
         */
        public void execute(Input atInput, Tracker atTracker) {
            String name = input.ask("Введите имя заявки :");
            Tipe tipe = tracker.findByName(name);
            if (tipe != null) {
            	tracker.delete(tipe);
            	System.out.println("Заявка удалена.");
			}else{
				System.out.println("Заявка не существует.");
			}
            
        }

        /**
         * 3-й элемент меню н экране.
         *
         * @return строка
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Delete Tipe.");
        }
    }

    /**
     * Класс Добавить комментарий.
     */
    private class AddComment implements UserAction {
        /**
         * Если выбран ключ 3.
         *
         * @return 3
         */
        public int key() {
            return 3;
        }

        /**
         * Метод класса.
         *
         * @param atInput ввод
         * @param atTracker трекер
         */
        public void execute(Input atInput, Tracker atTracker) {
            String id = input.ask("Введите номер заявки:");
            if (tracker.findById(id) != null) {
            	String comment = input.ask("Введите комментарий :");
                tracker.addComment(tracker.findById(id), comment);
                System.out.println("Комментарий добавлен.");
			}else{
				System.out.println("Заявка не найдена.");
			}
            
        }

        /**
         * 4-й элемент меню на экране.
         *
         * @return строка
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Add Comment.");
        }
    }

    /**
     * Класс Показать все заявки.
     */
    private class ShowAllTipes implements UserAction {
        /**
         * Если выбран ключ 4.
         *
         * @return 4
         */
        public int key() {
            return 4;
        }

        /**
         * Метод класса.
         *
         * @param atInput ввод.
         * @param atTracker трекер.
         */
        public void execute(Input atInput, Tracker atTracker) {
        		for (Tipe tipe : tracker.findByAll()) {
        			if (tipe != null) {
        				System.out.println(String.format("%s, %s", tipe.getName(), tipe.getDescription()));
					}
                    
                }
            
        }

        /**
         * 5-й элемент меню на экране.
         *
         * @return строка
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Show all Tipes.");
        }
    }

    /**
     * Класс Поиск по номеру.
     */
    private class FindById implements UserAction {
        /**
         * Если выбран ключ 5.
         *
         * @return 5
         */
        public int key() {
            return 5;
        }

        /**
         * Метод класса.
         *
         * @param atInput ввод
         * @param atTracker трекер
         */
        public void execute(Input atInput, Tracker atTracker) {
            String id = input.ask("Введите номер заявки :");
            if (tracker.findById(id) != null) {
            	 System.out.println(tracker.findById(id));
			}else{
				System.out.println("Заявка не существует.");
			}
           
        }

        /**
         * 6-й элемент меню на экране.
         *
         * @return строка
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find tipe by Id.");
        }
    }

    /**
     * Класс Поиск по имени.
     */
    private class FindByName implements UserAction {
        /**
         * если выбран ключ 6.
         *
         * @return 6
         */
        public int key() {
            return 6;
        }

        /**
         * Метод класса.
         *
         * @param atInput ввод
         * @param atTracker трекер
         */
        public void execute(Input atInput, Tracker atTracker) {
            String name = input.ask("Введите имя заявки :");
            if (tracker.findByName(name)!= null) {
				System.out.println(tracker.findByName(name));
			}else{
				System.out.println("Заявка не найдена.");
			}
            
        }

        /**
         * 7-й пункт меню.
         *
         * @return строка
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find Tipe by Name.");
        }
    }

    /**
     * Класс Поиск по описанию.
     */
    private class FindByDescription implements UserAction {
        /**
         * Если выбран элемент 7.
         *
         * @return 7
         */
        public int key() {
            return 7;
        }

        /**
         * Метод класса.
         *
         * @param atInput ввод
         * @param atTracker трекер
         */
        public void execute(Input atInput, Tracker atTracker) {
            String description = atInput.ask(
                    "Введите описание заявки :");
            if (tracker.findByDescription(description)!= null) {
				System.out.println(tracker.findByDescription(description));
			}else{
				System.out.println("Заявка не найдена.");
			}
            
        }

        /**
         * 8-й пункт меню на экране.
         *
         * @return строка
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find Tipe by Description.");
        }
    }
}
