package single;

import exception.BadActionValue;
import exception.BadIntValue;
import org.testng.Assert;
import org.testng.annotations.Test;
import validator.Validator;

import static validator.Validator.validateInputInt;

/**
 * Набор отдельных тестов для класса Validator
 */
public class ValidatorTest {

    /**
     * Проверка валидации строки при вводе целого числа, состоящего из одной цифры
     * @throws BadIntValue Добавление исключения в сигнатуру метода
     */
    @Test
    public void testValidateInputIntPositive() throws BadIntValue {
        String result = validateInputInt("7");
        Assert.assertEquals(result, "7");
    }

    /**
     * Проверка (негативная) валидации строки при вводе буквы
     * @throws BadIntValue Добавление исключения в сигнатуру метода
     */
    @Test (expectedExceptions = BadIntValue.class)
    public void testValidateInputLatinSymbolNegative() throws BadIntValue {
        String result = validateInputInt("A");
        Assert.assertEquals(result, "A");
    }

    /**
     * Проверка валидации строки при вводе целого числа, состоящего из пяти цифр
     * @throws BadIntValue Добавление исключения в сигнатуру метода
     */
    @Test
    public void testValidateInputIntPositive2() throws BadIntValue {
        String result = validateInputInt("50000");
        Assert.assertEquals(result, "50000");
    }

    /**
     * Проверка валидации строки при вводе целого числа, состоящего из трёх цифр
     * @throws BadIntValue Добавление исключения в сигнатуру метода
     */
    @Test
    public void testValidateInputIntPositive3() throws BadIntValue {
        String result = validateInputInt("999");
        Assert.assertEquals(result, "999");
    }

    /**
     * Проверка (негативная) валидации строки при пустой строке
     * @throws BadIntValue Добавление исключения в сигнатуру метода
     */
    @Test (expectedExceptions = BadIntValue.class)
    public void testValidateInputSpaceNegative() throws BadIntValue {
        String result = validateInputInt("");
        Assert.assertEquals(result, "");
    }

    /**
     * Проверка (негативная) валидации строки при вводе десятичного числа
     * @throws BadIntValue Добавление исключения в сигнатуру метода
     */
    @Test (expectedExceptions = BadIntValue.class)
    public void testValidateInputFloatNegative() throws BadIntValue {
        String result = validateInputInt("75.5");
        Assert.assertEquals(result, "75.5");
    }

    /**
     * Проверка валидации строки математического действия при вводе знака + (плюс)
     * @throws BadActionValue Добавление исключения в сигнатуру метода
     */
    @Test
    public void testValidateInputActionPlusPositive() throws BadActionValue {
        String result = Validator.validateInputAction("+");
        Assert.assertEquals(result, "+");
    }

    /**
     * Проверка валидации строки математического действия при вводе знака - (минус)
     * @throws BadActionValue Добавление исключения в сигнатуру метода
     */
    @Test
    public void testValidateInputActionMinusPositive() throws BadActionValue {
        String result = Validator.validateInputAction("-");
        Assert.assertEquals(result, "-");
    }

    /**
     * Проверка валидации строки математического действия при вводе двух знаков +- (плюс и минус)
     * @throws BadActionValue Добавление исключения в сигнатуру метода
     */
    @Test (expectedExceptions = BadActionValue.class)
    public void testValidateInputTwoActionNegative() throws BadActionValue {
        String result = Validator.validateInputAction("+-");
        Assert.assertEquals(result, "+-");
    }

    /**
     * Проверка валидации строки математического действия при вводе числа
     * @throws BadActionValue Добавление исключения в сигнатуру метода
     */
    @Test (expectedExceptions = BadActionValue.class)
    public void testValidateInputActionWithNumberNegative() throws BadActionValue {
        String result = Validator.validateInputAction("5");
        Assert.assertEquals(result, "5");
    }
}