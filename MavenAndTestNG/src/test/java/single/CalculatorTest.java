package single;

import calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Набор отдельных тестов для класса Calculator
 */
public class CalculatorTest {

    /**
     * Создание переменной с классом Calculator
     */
    private Calculator calculator;

    /**
     * Метод, который выполняется перед каждый тестом, создает объект класса
     */
    @BeforeMethod
    public void setUp(){
        calculator = new Calculator();
    }

    /**
     * Позитивная проверка, сложение
     */
    @Test
    public void testAdditionPositive(){
        int result = calculator.addition(240, 760);
        Assert.assertEquals (result,1000);
    }

    /**
     * Позитивная проверка, сложение
     */
    @Test
    public void testAdditionPositive2(){
        int result = calculator.addition(24, 7);
        Assert.assertEquals (result,31);
    }

    /**
     * Позитивная проверка, вычитание
     */
    @Test
    public void testSubtractionPositive(){
        int result = calculator.subtraction(450, 160);
        Assert.assertEquals (result,290);
    }

    /**
     * Позитивная проверка, вычитание
     */
    @Test
    public void testSubtractionPositive2(){
        int result = calculator.subtraction(40, 10);
        Assert.assertEquals (result,30);
    }

    /**
     * Позитивная проверка, умножение
     */
    @Test
    public void testMultiplicationPositive(){
        int result = calculator.multiplication(45, 10);
        Assert.assertEquals (result,450);
    }

    /**
     * Позитивная проверка, умножение
     */
    @Test
    public void testMultiplicationPositive2(){
        int result = calculator.multiplication(30, 3);
        Assert.assertEquals (result,90);
    }

    /**
     * Позитивная проверка, деление
     */
    @Test
    public void testDivisionPositive(){
        int result = calculator.division(99, 3);
        Assert.assertEquals (result,33);
    }

    /**
     * Позитивная проверка, деление
     */
    @Test
    public void testDivisionPositive2(){
        int result = calculator.division(990, 10);
        Assert.assertEquals (result,99);
    }

    /**
     * Негативная проверка, сложение
     */
    @Test
    public void testAdditionNegative(){
        int result = calculator.addition(240, 760);
        Assert.assertEquals (result,10000);
    }

    /**
     * Негативная проверка, вычитание
     */
    @Test
    public void testSubtractionNegative(){
        int result = calculator.subtraction(450, 160);
        Assert.assertEquals (result, 29);
    }

    /**
     * Негативная проверка, умножение
     */
    @Test
    public void testMultiplicationNegative(){
        int result = calculator.multiplication(45, 10);
        Assert.assertEquals (result,100);
    }

    /**
     * Негативная проверка, деление
     */
    @Test
    public void testDivisionNegative(){
        int result = calculator.division(99, 3);
        Assert.assertEquals (result, 330);
    }
}