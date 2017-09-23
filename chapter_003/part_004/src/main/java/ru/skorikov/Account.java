package ru.skorikov;
/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 04.09.17
 * @ version Stady_2.
 * Пакет 1 часть 3 Тестовое задание
 * Класс счет пользователя.
 */
public class Account {
    /**
     * Количество денег.
     */
    private double value;
    /**
     * Реквизиты счета.
     */
    private long requisites;

    /**
     * Конструктор.
     * @param value сумма.
     * @param requisites реквизиты.
     */
    public Account(double value, long requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Получить сумму денег на счету.
     * @return сумма.
     */
    public double getValue() {
        return value;
    }

    /**
     * Задать сумму денег.
     * @param value сумма.
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Получить реквизиты счета.
     * @return реквизиты.
     */
    public long getRequisites() {
        return requisites;
    }

    /**
     * Задать реквизиты счета.
     * @param requisites реквизиты.
     */
    public void setRequisites(long requisites) {
        this.requisites = requisites;
    }
}
