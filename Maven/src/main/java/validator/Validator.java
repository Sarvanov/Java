package validator;

import exception.BadActionValue;
import exception.BadIntValue;

/**
 * Класс для проверки на валидацию
 */
public class Validator {
    /**
     * @param input проверяемая строка
     * @return возвращает строку в случае прохождения проверки
     * @throws BadIntValue проверяет строку на наличие целого числа
     */
    public static String validateInputInt(String input) throws BadIntValue {
        if (input.matches("[0-9]")) {
            return input;
        } else {
            throw new BadIntValue("Вы ввели не целое число. Введите целое число");
        }
    }
    /**
     * @param inputAction проверяемая строка
     * @return возвращает строку в случае прохождения проверки
     * @throws BadActionValue проверяет строку на наличие математических знаков (+,-,*,/)
     */
    public static String validateInputAction (String inputAction) throws BadActionValue {
        if (inputAction.matches("[+\\-*/]")) {
            return inputAction;
        } else {
            throw new BadActionValue("Вы ввели неверное действие");
        }
    }
}
