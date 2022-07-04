package calculator;

/**
 * Класс Calculator необходим для совершения математических действий, таких как +-/*
 */
public class Calculator {
    /**
     * создание методов калькуляции
     * @param num1 - первое число
     * @param num2 - второе число
     * @return возвращает результат в зависимости от выбранной операции
     */

    public int addition(int num1, int num2) {
        return num1 + num2;
    }
    public int subtraction(int num1, int num2) {
        return num1 - num2;
    }
    public int multiplication(int num1, int num2) {
        return num1 * num2;
    }
    public int division(int num1, int num2) {
        return num1 / num2;
    }
}
