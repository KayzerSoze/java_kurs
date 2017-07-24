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
     * Диапазон значений меню.
     */
    private int[] range = new int[MenuTracker.RAZMER];

    {
        for (int i = 0; i < range.length; i++) {
            range[i] = i;
        }
    }

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
     * @param input   интерфейс.
     * @param tracker Трекер - хранишище заявок.
     */
    protected StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод класса.
     * @throws MenuOutException сообщение о ошибке.
     */
    public void init() throws MenuOutException {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("Select:", range));
        } while ((!"y".equals(this.input.ask("Exit: ? y/n"))));
    }

    /**
     * Метод запуска приложения.
     * @throws MenuOutException сообщение о ошибке.
     * @param args массив строк.
     */
    public static void main(String[] args) throws MenuOutException {
        /**
         * Интерфейс Input реализуем как ConsoleInput.
         */
        Input input = new ValidateInput();
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
