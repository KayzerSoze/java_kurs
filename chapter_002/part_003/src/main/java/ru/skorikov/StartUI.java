package ru.skorikov;
/**
Класс запуска приложения
Отображения описания и вывода меню.

@author Alexey Skorikov
@since 08.11.2016
@version 2.0
*/

public class StartUI {
	public Input input;

	public StartUI(Input input) {
		this.input = input;
	}

	public void start(Tracker tracker) {
        boolean exit = false;
        while (exit != true) {

            System.out.println("\t\t" + "Приветствие.");
            System.out.println("\t" + "Программа учета заявок.");
            System.out.println();
            System.out.println("1. Добавить заявку.");
            System.out.println("2. Редактировать заявку.");
            System.out.println("3. Удалить заявку.");
            System.out.println("4. Добавить коментарий.");
            System.out.println("5. Отобразить все заявки.");
            System.out.println("6. Искать заявку по ID.");
            System.out.println("7. Искать заявку по имени.");
            System.out.println("8. Искать заявку по описанию.");
            System.out.println("9. Выход.");

            String menu = this.input.ask("Выберите номер :");
            if (menu.equals("1")) {
                String name = this.input.ask("Введите имя заявки :");
                String description = this.input.ask("Введите описание заявки:");
                tracker.add(new Tipe(name, description));
            }
            if (menu.equals("2")) {
                String id = this.input.ask("Введите номер заявки :");
                String editingname = this.input.ask("Введите новое имя заявки :");
                String description = this.input.ask("Введите новое описание заявки :");
                Tipe tipe = new Tipe(editingname, description);
                tracker.editing(id, tipe);
            }
            if (menu.equals("3")) {
                String id = this.input.ask("Введите номер заявки :");
                tracker.delete(tracker.findById(id));
            }
            if (menu.equals("4")) {
                String id = this.input.ask("Введите номер заявки:");
                String comment = this.input.ask("Введите комментарий :");
                tracker.addComment(tracker.findById(id), comment);
            }
            if (menu.equals("5")) {
                tracker.findByAll();
            }
            if (menu.equals("6")) {
                String id = this.input.ask("Введите номер заявки :");
                tracker.findById(id);
            }
            if (menu.equals("7")) {
                String name = this.input.ask("Введите имя заявки :");
                tracker.findByName(name);
            }
            if (menu.equals("8")) {
                String description = this.input.ask("Введите описание заявки :");
                tracker.findByDescription(description);
            }
            if (menu.equals("9")) {
                String doexit = this.input.ask("Выйти из программы? Д/Н :");
                if (doexit.equals("Д") || doexit.equals("д")) {
                    exit = true;
                }
            }
        }
    }

	public static void main(String[] args) {
        Tracker tracker = new Tracker();
        new StartUI(new ConsoleInput()).start(tracker);

	}
}