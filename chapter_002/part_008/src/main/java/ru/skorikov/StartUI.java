package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex Skorikov.
 * @ date: 03.05.17
 * @ version Stady_2.
 */
class StartUI {
    /**
     * Интерфейс.
     * Переменная класса
     */
    private Input input;
    /**
     * Поле класса.
     * Переменная tracker.
     */
    private Tracker tracker;

    /**
     * Конструктор класса.
     *
     * @param input интерфейс.
     * @param tracker Трекер - хранишище заявок.
     */
    protected StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод класса.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Select."));
            menu.select(key);
        } while ((!"y".equals(this.input.ask("Exit: ? y/n"))));
    }

    /**
     * Метод запуска приложения.
     *
     * @param args массив строк.
     */
    public static void main(String[] args) {
        /**
         * Интерфейс Input реализуем как ConsoleInput.
         */
        Input input = new ConsoleInput();
        /**
         * Создаем новый объект класса Tracker.
         */
        Tracker tracker = new Tracker();
        /**
         * StartUI принимает input, tracker и запускает метод init.
         */
        new StartUI(input, tracker).init();
    }
}
