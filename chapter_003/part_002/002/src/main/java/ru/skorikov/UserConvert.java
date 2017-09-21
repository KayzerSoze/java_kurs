package ru.skorikov;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 04.09.17
 * @ version Stady_2.
 * Пакет 1 часть 3 задание 2-2
 * Написать программу преобразования List в Map
 * Класс конвертирует list в Map.
 */
public class UserConvert {
    /**
     * Метод принимает List и конвертиурует его в Map.
     *
     * @param list List.
     * @return Map.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User user : list) {
            int id = user.getId();
            map.put(id, user);
        }
        return map;
    }
}
