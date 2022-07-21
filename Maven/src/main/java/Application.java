import calculator.Calculator;
import exception.BadActionValue;
import exception.BadIntValue;
import exception.DivisionByZeroException;

import java.util.Scanner;

import static java.lang.System.in;
import static validator.Validator.validateInputAction;
import static validator.Validator.validateInputInt;

public class Application {

    public static void main(String[] args) throws BadActionValue, BadIntValue {

        // Создание scanner для считывания с консоли
        Scanner scanner = new Scanner(in);

        // Создание бесконечного цикла
        while (true) {

            // Создание объекта calculator
            Calculator calculator = new Calculator();

            // Задаем переменные типа int
            int num1, num2, result;

            //Вывод сообщения для ввода первого числа
            System.out.print("Введите первое число: ");

            // Валидация num1
            num1 = Integer.parseInt(validateInputInt(scanner.next()));

            // Вывод сообщения для ввода операции
            System.out.print("Введите математическое действие: ");

            // Валидация математического действия
            String action = validateInputAction(scanner.next());

            // Вывод сообщения для ввода второго числа
            System.out.print("Введите второе число: ");

            // Валидация num2
            num2 = Integer.parseInt(validateInputInt(scanner.next()));

            // Вызов метода класса Calculator в зависимости от выбранной операции
            switch (action) {
                case "+":
                    result = calculator.addition(num1, num2);
                    break;
                case "-":
                    result = calculator.subtraction(num1, num2);
                    break;
                case "*":
                    result = calculator.multiplication(num1, num2);
                    break;
                case "/":
                    if (num2 != 0)
                        result = calculator.division(num1, num2);
                    else {
                        try {
                            throw new DivisionByZeroException("На ноль делить нельзя"); // в случае деления на 0 выбрасывается исключение
                        } catch (DivisionByZeroException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                default:
                    try {
                        throw new BadActionValue("Вы ввели неверное действие");
                    } catch (BadActionValue e) {
                        throw new RuntimeException(e);
                    }
            }
            // Вывод сообщения с результатом вычисления
            System.out.println("Результат = " + result);

            // Вывод сообщения о завершении операции
            System.out.println("Операция завершена");
        }
    }
}