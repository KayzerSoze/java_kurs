package ru.skorikov;
/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 04.09.17
 * @ version Stady_2.
 * Пакет 1 часть 3 Тестовое задание.
 * Тесты класса Банк.
 */

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Класс тестирует класс Bank.
 */
public class BankTest {
    /**
     * Банк.
     */
    private static Bank bank;
    /**
     * Отправитель.
     */
    private static User sender;
    /**
     * Получатель.
     */
    private static User recipient;
    /**
     * 1 счет отравителя.
     */
    private static Account accountSender;
    /**
     * 2 счет отправителя.
     */
    private static Account accountSender2;
    /**
     * 1 счет получателя.
     */
    private static Account accountRecipient;
    /**
     * 2 счет получателя.
     */
    private static Account accountRecipient2;

    /**
     * Перед запусков тестов выполнится это.
     */
    @BeforeClass
    public static void initializeTests() {
        bank = new Bank();
        sender = new User("Sender", "Russia");
        recipient = new User("Recipient", "Belarus");
        accountSender = new Account(1000.0, 10000001);
        accountSender2 = new Account(0.0, 1000002);
        accountRecipient = new Account(1000.0, 1000001);
        accountRecipient2 = new Account(0.0, 1000002);
    }


    /**
     * Проверим добавление пользователя.
     *
     * @throws Exception возможно исключение.
     */
    @Test
    public void isAddUserToBank() throws Exception {
        bank.addUser(sender);
        Assert.assertTrue(bank.getBank().containsKey(sender));
    }

    /**
     * Проверим удаление пользователя из банка.
     *
     * @throws Exception возможно исключение.
     */
    @Test
    public void isDeleteUserFromBank() throws Exception {
        bank.addUser(sender);
        bank.deleteUser(sender);
        Assert.assertFalse(bank.getBank().containsKey(sender));

    }

    /**
     * Проверим добавление счета пользователю.
     *
     * @throws Exception возможно исключение.
     */
    @Test
    public void isAddAccountToUser() throws Exception {
        bank.addUser(sender);
        bank.addAccountToUser(sender, accountSender);
        Assert.assertTrue(bank.getBank().get(sender).contains(accountSender));
    }

    /**
     * Проверим удаление одного из счетов пользователя.
     *
     * @throws Exception возможно исключение.
     */
    @Test
    public void isDeleteAccountFromUser() throws Exception {
        bank.addUser(sender);
        bank.addAccountToUser(sender, accountSender);
        bank.addAccountToUser(sender, accountSender2);
        bank.deleteAccountFromUser(sender, accountSender);
        Assert.assertFalse(bank.getBank().get(sender).contains(accountSender));
    }

    /**
     * Проверим получить счета пользователя.
     *
     * @throws Exception возможно исключение.
     */
    @Test
    public void isGetUserAccounts() throws Exception {
        bank.addUser(recipient);
        bank.addAccountToUser(recipient, accountRecipient);
        bank.addAccountToUser(recipient, accountRecipient2);
        Assert.assertTrue(bank.getBank().get(recipient).contains(accountRecipient));
        Assert.assertTrue(bank.getBank().get(recipient).contains(accountRecipient2));
        Assert.assertFalse(bank.getBank().get(recipient).contains(accountSender));
    }

    /**
     * Проверим перевод денег.
     *
     * @throws Exception возможно исключение.
     */
    @Test
    public void isTransferMoney() throws Exception {
        bank.addUser(sender);
        bank.addAccountToUser(sender, accountSender);
        bank.addUser(recipient);
        bank.addAccountToUser(recipient, accountRecipient);
        boolean b = bank.transferMoney(sender, accountSender, recipient, accountRecipient, 500);
        Assert.assertTrue(b);
    }

}