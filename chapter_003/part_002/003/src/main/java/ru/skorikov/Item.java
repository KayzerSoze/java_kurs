package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 03.05.17
 * @ version Stady_2.
 * Класс описывает заявку с которой будет работать класс Tracker.
 */
public class Item {
    /**
     * Заявка имеет имя.
     */
    private String name;
    /**
     * Описание заявки.
     */
    private String description;
    /**
     * Id Заявки.
     */
    private String id;
    /**
     * Конструктор класса.
     *
     * @param name        первый принимаемый параметр - имя.
     * @param description второй параметр - описание.
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Получить имя заявки.
     *
     * @return имя.
     */
    public String getName() {
        return name;
    }

    /**
     * Установить имя заявки.
     *
     * @param name имя.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получить описаание заявки.
     *
     * @return описание.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Задать описание заявки.
     *
     * @param description описание.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Получить ID заявки.
     *
     * @return ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Задать ID заявки.
     *
     * @param id ID.
     */
    public void setId(String id) {
        this.id = id;
    }
}
