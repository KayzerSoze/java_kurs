package ru.skorikov;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 04.09.17
 * @ version Stady_2.
 * Пакет 1 часть 3 задание 3-1
 * Организовать сортировку User
 * Класс User.
 */
class SortUser {
    /**
     * Метод должен возвращать TreeSet пользователей.
     * отсортированных по возрасту в порядке возрастания.
     * @param userList List.
     * @return Set
     */
    public Set<User> sort(List<User> userList) {
        TreeSet<User> userSet = new TreeSet<>();
        for (User user : userList) {
            userSet.add(user);
        }
        return userSet;
    }

}