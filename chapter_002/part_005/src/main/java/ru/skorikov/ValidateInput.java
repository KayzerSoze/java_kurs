package ru.skorikov;

/**
 * Класс Проверки ввода.
 *
 * @author Alexey Skorikov
 * @version 1.0
 * @since 18.12.2016
 */
public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range){
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            }catch (NumberFormatException nfe){
                System.out.println("Please enter validate date again.");
            }
        }
        while (invalid);

        return value;
    }

}
