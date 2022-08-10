package validator;

import exception.BadActionValue;
import exception.BadIntValue;

/**
 * Класс для проверки на валидацию
 */
public class Validator {

    /**
     * @param num проверяемая строка
     * @return возвращает строку в случае прохождения проверки
     * @throws BadIntValue проверяет строку на наличие целого числа
     */
    public static String validateInputInt(String num) throws BadIntValue {
        if (num.matches ("-?\\d+")) {
            return num;
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
        if (inputAction.matches ("[+\\-*/]")) {
            return inputAction;
        } else {
            throw new BadActionValue("Вы ввели неверное действие");
        }
    }
}