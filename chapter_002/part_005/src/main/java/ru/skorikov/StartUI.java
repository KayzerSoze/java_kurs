package ru.skorikov;

/**
 * Класс запуска приложения
 * Отображения описания и вывода меню.
 *
 * @author Alexey Skorikov
 * @version 4.01
 * @since 20.11.2016
 */

public class StartUI {
    /**
     * Диапазон значений меню.
     */
	
    private int range[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
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
            menu.select(input.ask("Select:", range));
        } while ((!"y".equals(this.input.ask("Exit: ? y/n"))));
    }
    /**
     * Класс запуска приложения.
     *
     * @param args массив строк
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ValidateInput();
        new StartUI(input, tracker).start();

    }
}