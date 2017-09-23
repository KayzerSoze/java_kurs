package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 04.09.17
 * @ version Stady_2.
 * Пакет 1 часть 3 Тестовое задание
 * Класс Пользователь Банка.
 */
public class User {
    /**
     * Имя.
     */
    private String name;
    /**
     * Паспорт.
     */
    private String passport;

    /**
     * Конструктор.
     * @param name имя.
     * @param passport паспорт.
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Получить имя.
     * @return имя.
     */
    public String getName() {
        return name;
    }

    /**
     * Задать имя.
     * @param name имя.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получить паспорт.
     * @return паспорт.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Задать паспорт.
     * @param passport паспорт.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return passport != null ? passport.equals(user.passport) : user.passport == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        return result;
    }
}
