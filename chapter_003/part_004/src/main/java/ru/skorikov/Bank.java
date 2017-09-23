package ru.skorikov;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 04.09.17
 * @ version Stady_2.
 * Пакет 1 часть 3 Тестовое задание
 * Класс Банк.
 * Работает с пользователями и их счетами.
 */
public class Bank {

    /**
     * Хранилище пользователей и их счетов.
     */
    private Map<User, List<Account>> bank = new HashMap<User, List<Account>>();

    /**
     * Получить банк.
     *
     * @return банк.
     */
    public Map<User, List<Account>> getBank() {
        return bank;
    }

    /**
     * Добавить пользователя в банк.
     *
     * @param user пользователь.
     */
    public void addUser(User user) {
        //Если банк не содержит такого пользователя.
        if (!bank.containsKey(user)) {
            //Добавим его.
            bank.put(user, new ArrayList<Account>());
        }
    }

    /**
     * Удалить пользователя из банка.
     *
     * @param user пользователь.
     */
    public void deleteUser(User user) {
        Iterator<Map.Entry<User, List<Account>>> iterator = bank.entrySet().iterator();
        //Пройдем по банку.
        while (iterator.hasNext()) {
            Map.Entry<User, List<Account>> pov = iterator.next();
            //Если найдем такого пользователя.
            if (pov.getKey().equals(user)) {
                //Удалим его.
                iterator.remove();
            }
        }
    }

    /**
     * Добавить счет пользователю.
     *
     * @param user    пользователь.
     * @param account счет.
     */
    public void addAccountToUser(User user, Account account) {
        Iterator<Map.Entry<User, List<Account>>> iterator = bank.entrySet().iterator();
        //Проход по банку.
        while (iterator.hasNext()) {
            Map.Entry<User, List<Account>> pov = iterator.next();
            //Если найдем такого пользователя.
            if (pov.getKey().equals(user)) {
                //Добавим счет.
                pov.getValue().add(account);
            }
        }

    }

    /**
     * Удалить один счет пользователя.
     *
     * @param user    пользователь.
     * @param account счет.
     */
    public void deleteAccountFromUser(User user, Account account) {
        Iterator<Map.Entry<User, List<Account>>> iterator = bank.entrySet().iterator();
        //Пройдем по банку.
        while (iterator.hasNext()) {
            Map.Entry<User, List<Account>> pov = iterator.next();
            //Если есть такой пользователь.
            if (pov.getKey().equals(user)) {
                //Получим список его счетов.
                List<Account> list = pov.getValue();
                ListIterator<Account> iterator1 = list.listIterator();
                //Пройдем по счетам.
                while (iterator1.hasNext()) {
                    Account account1 = iterator1.next();
                    //Если найдем такой счет.
                    if (account.equals(account1)) {
                        //Удалим его.
                        iterator1.remove();
                    }
                }
            }
        }
    }

    /**
     * Получить список счетов пользователя.
     *
     * @param user пользователь.
     * @return список счетов.
     */
    public List<Account> getUserAccounts(User user) {
        //Новый список счетов.
        List<Account> getAccouns = new ArrayList<>();
        Iterator<Map.Entry<User, List<Account>>> iterator = bank.entrySet().iterator();
        //Пройдем по банку.
        while (iterator.hasNext()) {
            Map.Entry<User, List<Account>> pov = iterator.next();
            //Если найдем такого пользователя.
            if (pov.getKey().equals(user)) {
                //Получим список его счетов.
                getAccouns = pov.getValue();
            }
        }
        return getAccouns;
    }

    /**
     * Метод для перечисления денег с одного счета на другой.
     *
     * @param srcUser    Пользователь переводит.
     * @param srcAccount Счет с которого списывают.
     * @param dstUser    Пользователь получатель.
     * @param dstAccount Счет получателя.
     * @param amount     сумма.
     * @return удалась операция или нет.
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean successful = false;

        Iterator<Map.Entry<User, List<Account>>> iterBank = bank.entrySet().iterator();
        //Пройдем по банку.
        while (iterBank.hasNext()) {
            Map.Entry<User, List<Account>> bank = iterBank.next();
            //Найдем отправителя.
            if (bank.getKey().equals(srcUser)) {
                //Если найдем - получим список счетов.
                List<Account> list = bank.getValue();
                ListIterator<Account> iterList = list.listIterator();
                while (iterList.hasNext()) {
                    Account account = iterList.next();
                    //Если есть такой счет и на нем хватает денег.
                    if (account.equals(srcAccount) && account.getValue() >= amount) {
                        account.setValue(account.getValue() - amount);
                        successful = true;
                    }
                }
            }
        }
        //Если у отправителя все нормально.
        if (successful) {
            Iterator<Map.Entry<User, List<Account>>> iterBank2 = bank.entrySet().iterator();
            while (iterBank2.hasNext()) {
                Map.Entry<User, List<Account>> bank = iterBank2.next();
                //Найдем получателя.
                if (bank.getKey().equals(dstUser)) {
                    //Получим список его счетов.
                    List<Account> list = bank.getValue();
                    ListIterator<Account> iterList = list.listIterator();
                    //Пройдем по счетам.
                    while (iterList.hasNext()) {
                        Account account = iterList.next();
                        //Если найдем тайкой счет.
                        if (account.equals(dstAccount)) {
                            //Добавим ему сумму.
                            account.setValue(account.getValue() + amount);
                        }
                    }
                }

            }
        }
        return successful;
    }
}
