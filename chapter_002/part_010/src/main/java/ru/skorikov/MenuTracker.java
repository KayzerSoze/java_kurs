package ru.skorikov;


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
        this.actions[0] = new AddItem("AddItem", 0);
        this.actions[1] = new ShowAllItems("ShowAllItems", 1);
        this.actions[2] = new EditItem("EditItem", 2);
        this.actions[3] = new DeleteItem("DeleteItem", 3);
        this.actions[4] = new FindById("FindById", 4);
        this.actions[5] = new FindByName("FindByName", 5);
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
    private class AddItem extends BaseAction {
        /**
         * Конструктор.
         *
         * @param name имя.
         * @param key  ключ.
         */
        AddItem(String name, int key) {
            super(name, key);
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
            return String.format("%s. %s", this.key(), this.name());
        }
    }

    /**
     * 1. Класс Показать все заявки.
     */
    private class ShowAllItems extends BaseAction {
        /**
         * Конструктор.
         *
         * @param name имя.
         * @param key  ключ.
         */
        ShowAllItems(String name, int key) {
            super(name, key);
        }

        /**
         * Метод класса.
         *
         * @param atInput   ввод.
         * @param atTracker трекер.
         */
        public void execute(Input atInput, Tracker atTracker) {
            for (Item item : tracker.findAll()) {
                if (item != null) {
                    System.out.println(item.getId() + " "
                            + item.getName() + " "
                            + item.getDescription());
                }
            }
        }

        /**
         * 2-й элемент меню на экране.
         *
         * @return строка
         */
        public String info() {
            return String.format("%s. %s", this.key(), this.name());
        }
    }

    /**
     * 2. Класс Редактировать заявку.
     */
    private class EditItem extends BaseAction {
        /**
         * Конструктор класса.
         *
         * @param name имя.
         * @param key  ключ.
         */
        EditItem(String name, int key) {
            super(name, key);
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
            return String.format("%s. %s", this.key(), this.name());
        }
    }

    /**
     * 3. Класс удалить заявку.
     */
    private class DeleteItem extends BaseAction {
        /**
         * Конструктор.
         *
         * @param name имя
         * @param key  ключ.
         */
        DeleteItem(String name, int key) {
            super(name, key);
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
            return String.format("%s. %s", this.key(), this.name());
        }
    }

    /**
     * 4. Класс Поиск по номеру.
     */
    private class FindById extends BaseAction {
        /**
         * Конструктор.
         *
         * @param name имя.
         * @param key  ключ.
         */
        FindById(String name, int key) {
            super(name, key);
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
            return String.format("%s. %s", this.key(), this.name());
        }
    }

    /**
     * 5. Класс Поиск по имени.
     */
    private class FindByName extends BaseAction {
        /**
         * Конструктор.
         *
         * @param name имя.
         * @param key  ключ.
         */
        FindByName(String name, int key) {
            super(name, key);
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
            return String.format("%s. %s", this.key(), this.name());
        }
    }

}
