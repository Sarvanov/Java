package calculator;

import exception.BadActionValue;
import exception.ZeroException;

import java.util.Scanner;

/**
 * Класс Calculator необходим для совершения математических действий, таких как +-/*
 */
public class Calculator {
    // Создание scanner для считывания с консоли
    Scanner scanner = new Scanner(System.in);{

        // Вывод сообщения для ввода первого числа типа int
        System.out.println("Введите первое число");
        int num1;
        /**
         * Проверка, что если пользователь вводит число типа int, то в переменную num1 присваивается это введенное значение
         */
        if (scanner.hasNextInt()) {
            num1 = scanner.nextInt();
            /**
             * Если пользователь ввёл не целое число или любой другой символ выбрасывается исключение с сообщением
             */
        } else {
            try {
                throw new exception.BadIntValue("Вы ввели не целое число. Введите целое число");
            } catch (exception.BadIntValue e) {
                throw new RuntimeException(e);
            }
        }
        // Вывод сообщения для ввода второго числа типа int
        System.out.println("Введите второе число");
        int num2;
        /**
         * Проверка, что если пользователь вводит число типа int, то в переменную num2 присваивается это введенное значение
         */
        if (scanner.hasNextInt()) {
            num2 = scanner.nextInt();
            /**
             * Если пользователь ввёл не целое число или любой другой символ выбрасывается исключение с сообщением
             */
        } else {
            try {
                throw new exception.BadIntValue("Вы ввели не число. Введите число");
            } catch (exception.BadIntValue e) {
                throw new RuntimeException(e);
            }
        }
        // Вывод сообщения для ввода операции типа char
        System.out.println("Введите математическое действие");
        char action = scanner.next().charAt(0);
        // Переменная result будет типа int
        int result;
        /**
         * Если пользователь выбрал действие сложение (+), то на экран выводится значение result, равное сумме num1 и num2
         */
        if (action == '+') {
            result = num1 + num2;
            System.out.println("Результат = " + result);
            /**
             * Если пользователь выбрал действие вычитание (-), то на экран выводится значение result, равное разности num1 и num2
             */
        } else if (action == '-') {
            result = num1 - num2;
            System.out.println("Результат = " + result);
            /**
             * Если пользователь выбрал действие умножение (*), то на экран выводится значение result, равное произведению num1 и num2
             */
        } else if (action == '*') {
            result = num1 * num2;
            System.out.println("Результат = " + result);
            /**
             * Если пользователь выбрал действие деление (/), то на экран выводится значение result, равное частному num1 и num2
             * Если знаменатель равен 0, то выбрасывается исключение с сообщением, что на ноль делить нельзя
             */
        } else if (action == '/') {
            if (num2 == 0) {
                try {
                    throw new ZeroException("На ноль делить нельзя");
                } catch (ZeroException e) {
                    throw new RuntimeException(e);
                }
            }
            result = num1 / num2;
            System.out.println("Результат = " + result);
        } else try {
            throw new BadActionValue("Вы ввели неверное действие");
        } catch (BadActionValue e) {
            throw new RuntimeException(e);
        }
        // Вывод сообщения о завершении операции
        System.out.println("Операция завершена");
    }
}
