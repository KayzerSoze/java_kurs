package ru.skorikov;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 04.09.17
 * @ version Stady_2.
 * Пакет 1 часть 3 задание 3-1
 * Сортировка User с использованием Comparator
 * Класс SortUser.
 */
class SortUser {
    /**
     * Метод сортирует List по длине имени.
     *
     * @param userList List.
     * @return sortedList.
     */
    public List<User> sortNameLength(List<User> userList) {
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        return userList;
    }

    /**
     * Метод сортирует List по длине имени и по возрасту.
     *
     * @param userList List.
     * @return sortedList.
     */
    public List<User> sortByAllFields(List<User> userList) {
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int name = o1.getName().length() - o2.getName().length();
                if (name == 0) {
                    return o1.getAge() - o2.getAge();
                } else {
                    return name;
                }
            }
        });
        return userList;
    }
}