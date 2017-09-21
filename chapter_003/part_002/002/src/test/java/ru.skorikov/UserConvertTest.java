package ru.skorikov;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 04.09.17
 * @ version Stady_2.
 * Пакет 1 часть 3 задание 2-2
 * Написать программу преобразования List в Map
 * Класс Тест.
 */
public class UserConvertTest {
    /**
     * Проверим конвертацию листа в карту.
     */
    @Test
    public void isConverUserListToUserMap() {
        UserConvert userConvert = new UserConvert();
        ArrayList<User> list = new ArrayList<>();
        User user1 = new User(1, "name1", "sity");
        User user2 = new User(2, "name2", "sity");
        User user3 = new User(3, "name3", "sity");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        HashMap<Integer, User> map1 = new HashMap<>();
        map1.put(user1.getId(), new User(user1.getName(), user1.getSity()));
        map1.put(user2.getId(), new User(user2.getName(), user2.getSity()));
        map1.put(user3.getId(), new User(user3.getName(), user3.getSity()));

        HashMap<Integer, User> map2 = userConvert.process(list);

        Assert.assertEquals(map1, map2);

    }

}