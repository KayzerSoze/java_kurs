package ru.skorikov;

import java.util.Arrays;
import java.util.Scanner;

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
     * Переменная класса?
     */
    private Input input;

    /**
     * Конструктор класса.
     *
     * @param input интерфейс.
     */
    private StartUI(Input input) {
        this.input = input;
    }

    /**
     * Метод класса.
     */
    private void init() {

        Tracker tracker = new Tracker();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        do {
            for (MenuLevel menuLevel : MenuLevel.values()) {
                System.out.println(menuLevel.ordinal()
                        + ". "
                        + menuLevel.getNameMenuLevel());
            }
            System.out.println("Select:");
            int select = scanner.nextInt();

            switch (MenuLevel.values()[select]) {
                case ADD:
                    String name = input.ask("Enter Item name:");
                    String description = input.ask("Enter Item description:");
                    if (tracker.getPosition() < 10) {
                        Item item = new Item(name, description);
                        tracker.add(item);
                    } else {
                        System.out.println("Нет места.");
                        System.out.println("Удалите одну или несколько заявок.");
                    }
                    break;
                case SHOWALL:
                    System.out.println(Arrays.asList(tracker.findAll()));
                    break;
                case EDIT:
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
                    break;
                case DELETE:
                    String findIdItem = input.ask("Enter ID item:");
                    Item findItem = tracker.findeById(findIdItem);
                    if (findItem == null) {
                        System.out.println("Item not found.");
                    } else {
                        tracker.delete(findItem);
                        System.out.println("Item deleted.");
                    }
                    break;
                case FINDBYID:
                    String findItemById = input.ask("Enter ID item:");
                    if (tracker.findeById(findItemById) != null) {
                        tracker.findeById(findItemById);
                        System.out.println(findItemById);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case FINDBYNAME:
                    String findItemByName = input.ask("Enter Name item:");
                    if (tracker.findeByName(findItemByName) != null) {
                        tracker.findeByName(findItemByName);
                        System.out.println(findItemByName);
                    } else {
                        System.out.println("Item not found.");
                    }

                    break;
                case EXIT:
                    String vopros = input.ask("Exit programm: y/n?");
                    if ((vopros.equals("y")) || (vopros.equals("Y"))) {
                        exit = true;
                    } else {
                        break;
                    }
                default:
                    break;
            }
        } while (!exit);
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
         * StartUI принимает input и запускает метод init.
         */
        new StartUI(input).init();
    }
}
