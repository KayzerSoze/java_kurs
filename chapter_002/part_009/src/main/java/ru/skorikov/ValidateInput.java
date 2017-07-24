package ru.skorikov;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex Skorikov.
 * @ date: 24.07.17
 * @ version Stady_2.
 */
public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range) throws MenuOutException {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate date again.");
            }
        }
        while (invalid);

        return value;
    }
}
