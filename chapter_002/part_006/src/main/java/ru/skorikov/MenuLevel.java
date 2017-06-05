package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 * Перечисление констант.
 *
 * @ author: Alex Skorikov.
 * @ date: 03.05.17
 * @ version Stady_2.
 */
public enum MenuLevel {
    /**
     * Добавить заявку.
     */
    ADD("Add new Item."),
    /**
     * Показать все заявки.
     */
    SHOWALL("Show all Items."),
    /**
     * Удалить заявку.
     */
    DELETE("Delete Item."),
    /**
     * Редактировать заявку.
     */
    EDIT("Edit Item."),
    /**
     * Поиск заявки по Id.
     */
    FINDBYID("Find Iten by Id."),
    /**
     * Поиск заявки по имени.
     */
    FINDBYNAME("Find Item by Name."),
    /**
     * Выход из программы.
     */
    EXIT("Exit programm.");
    /**
     * Имя константы.
     */
    private String nameMenuLevel;

    /**
     * Конструктор класса.
     *
     * @param nameMenuLevel имя константы.
     */
    MenuLevel(String nameMenuLevel) {
        this.nameMenuLevel = nameMenuLevel;
    }

    /**
     * Геттер имени константы.
     *
     * @return имя константы.
     */
    public String getNameMenuLevel() {
        return nameMenuLevel;
    }

}
