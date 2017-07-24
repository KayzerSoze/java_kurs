package ru.skorikov;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex Skorikov.
 * @ date: 17.07.17
 * @ version Stady_2.
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
    static final int RAZMER = 6;
    /**
     * New instance of the class UserAction.
     */
    private UserAction[] actions = new UserAction[RAZMER];

    /**
     * Конструктор класса.
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
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowAllItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
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
     * 0. Внутренний класс - добавить заявку.
     */
    private class AddItem implements UserAction {
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
            String name = input.ask("Enter Item name:");
            String description = input.ask("Enter Item description:");
            if (tracker.getPosition() < 10) {
                Item item = new Item(name, description);
                tracker.add(item);
            } else {
                System.out.println("Нет места.");
                System.out.println("Удалите одну или несколько заявок.");
            }
        }

        /**
         * 1-й элемент меню на экране.
         *
         * @return строка.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Add new Item.");
        }
    }

    /**
     * 1. Класс Показать все заявки.
     */
    private class ShowAllItems implements UserAction {
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
         * @param atInput   ввод.
         * @param atTracker трекер.
         */
        public void execute(Input atInput, Tracker atTracker) {
            System.out.println(Arrays.asList(tracker.findAll()));

        }

        /**
         * 2-й элемент меню на экране.
         *
         * @return строка
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Show all Items.");
        }
    }

    /**
     * 2. Класс Редактировать заявку.
     */
    private class EditItem implements UserAction {
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
         * @param atInput   ввод
         * @param atTracker трекер
         */
        public void execute(Input atInput, Tracker atTracker) {
            String idItem = input.ask("Enter ID item:");
            if (tracker.findeById(idItem) != null) {
                String newName = input.ask("Enter new name:");
                String newDescription = input.ask("Enter new description");
                Item editItem = new Item(newName, newDescription);
                tracker.update(idItem, editItem);
                System.out.println("Item changed.");
            } else {
                System.out.println("Item not found.");
            }

        }

        /**
         * 3-й элемент меню на экране.
         *
         * @return строка
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Edit Item.");
        }
    }

    /**
     * 3. Класс удалить заявку.
     */
    private class DeleteItem implements UserAction {
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
         * @param atInput   ввод
         * @param atTracker трекер
         */
        public void execute(Input atInput, Tracker atTracker) {
            String findIdItem = input.ask("Enter ID item:");
            Item findItem = tracker.findeById(findIdItem);
            if (findItem == null) {
                System.out.println("Item not found.");
            } else {
                tracker.delete(findItem);
                System.out.println("Item deleted.");
            }

        }

        /**
         * 4-й элемент меню н экране.
         *
         * @return строка
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Delete Item.");
        }
    }

    /**
     * 4. Класс Поиск по номеру.
     */
    private class FindById implements UserAction {
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
         * @param atInput   ввод
         * @param atTracker трекер
         */
        public void execute(Input atInput, Tracker atTracker) {
            String findItemById = input.ask("Enter ID item:");
            if (tracker.findeById(findItemById) != null) {
                tracker.findeById(findItemById);
                System.out.println(findItemById);
            } else {
                System.out.println("Item not found.");
            }
        }

        /**
         * 5-й элемент меню на экране.
         *
         * @return строка
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find Item by Id.");
        }
    }

    /**
     * 5. Класс Поиск по имени.
     */
    private class FindByName implements UserAction {
        /**
         * если выбран ключ 5.
         *
         * @return 5
         */
        public int key() {
            return 5;
        }

        /**
         * Метод класса.
         *
         * @param atInput   ввод
         * @param atTracker трекер
         */
        public void execute(Input atInput, Tracker atTracker) {
            String findItemByName = input.ask("Enter Name item:");
            if (tracker.findeByName(findItemByName) != null) {
                tracker.findeByName(findItemByName);
                System.out.println(findItemByName);
            } else {
                System.out.println("Item not found.");
            }
        }

        /**
         * 6-й пункт меню.
         *
         * @return строка
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find Item by Name.");
        }
    }

}
