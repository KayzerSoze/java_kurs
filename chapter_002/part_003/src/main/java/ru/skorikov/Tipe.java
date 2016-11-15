package ru.skorikov;

/**
 * Класс заявка.
 *
 * @author Alexey Skorikov
 * @version 2.0
 * @since 10.11.2016
 */
public class Tipe {
    /**
     * Номер заявки.
     */
    private String id;
    /**
     * Имязаявки.
     */
    private String name;
    /**
     * Дата заявки.
     */
    private long date;
    /**
     * Описание заявки.
     */
    private String description;
    /**
     * Комментраий заявки.
     */
    private String comment;

    /**
     * Заявка.
     */
    public Tipe() {
    }

    /**
     * Конструктор.
     *
     * @param setName        имя
     * @param setDescription описание
     */
    public Tipe(String setName, String setDescription) {
        this.name = setName;
        this.description = setDescription;
    }

    /**
     * Присвоим номер.
     *
     * @param setId номер заявки
     */
    public void setId(String setId) {
        this.id = setId;
    }

    /**
     * Получим номер заяки.
     *
     * @return номер
     */
    public String getId() {
        return id;
    }

    /**
     * Установим имя заявки.
     *
     * @param setName имя
     */
    public void setName(String setName) {
        this.name = setName;
    }

    /**
     * Получим имя заявки.
     *
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * Присвоим дату завки.
     *
     * @param setDate дата
     */
    public void setDate(long setDate) {
        this.date = setDate;
    }

    /**
     * Получим дату заявки.
     *
     * @return дата
     */
    public long getDate() {
        return date;
    }

    /**
     * Присвоим описание.
     *
     * @param setDescription описание
     */
    public void setDescription(String setDescription) {
        this.description = setDescription;
    }

    /**
     * Получим описание заявки.
     *
     * @return описание
     */
    public String getDescription() {
        return description;
    }

    /**
     * Присвоим комментарий.
     *
     * @param setComment комментарий
     */
    public void setComment(String setComment) {
        this.comment = setComment;
    }

    /**
     * Получаем комментарий.
     *
     * @return комментарий
     */
    public String getComment() {
        return comment;
    }
}