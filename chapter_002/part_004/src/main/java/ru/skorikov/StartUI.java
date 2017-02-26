package ru.skorikov;

/**
 * Класс запуска приложения
 * Отображения описания и вывода меню.
 *
 * @author Alexey Skorikov
 * @version 4.0
 * @since 20.11.2016
 */

public class StartUI {
    /**
     * Интерфейс input.
     */
    private Input input;
    /**
     * Трекер.
     */
    private Tracker tracker;

    /**
     * Запуск класса StartUI.
     *
     * @param atInput интерфейс
     * @param atTracker трекер
     */
    public StartUI(Input atInput, Tracker atTracker) {
        this.input = atInput;
        this.tracker = atTracker;
    }


    /**
     * Метод запусскает программу.
     */
    public void start() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Select."));
            menu.select(key);
        } while ((!"y".equals(this.input.ask("Exit: ? y/n"))));
    }

    /**
     * Класс запуска приложения.
     *
     * @param args массив строк
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ConsoleInput();
        StartUI startUI = new StartUI(input, tracker);
        startUI.start();

    }
}