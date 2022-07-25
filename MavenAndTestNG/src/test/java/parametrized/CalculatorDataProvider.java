package parametrized;

import calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Набор тестов с DataProvider для класса Calculator
 */
public class CalculatorDataProvider {

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
     * DataProvider с тестовыми данными и ожидаемым результатом для тестов (сложение)
     *
     * @return двумерный массив объектовый (стандартный return для DataProvider)
     */
    @DataProvider
    public Object[][] testAndExpectedAdditionPositiveData(){
        return new Integer[][]{
                {240, 760, 1000},
                {24, 7, 31},
                {65, 5, 70}
        };
    }

    /**
     * Параметризированный тест для сложения
     * @param num1 тестовые данные
     * @param num2 тестовые данные
     * @param result результат
     */
    @Test(dataProvider = "testAndExpectedAdditionPositiveData")
    public void testAdditionDataProvider(int num1, int num2, int result){
        calculator.addition(num1,num2);
        Assert.assertEquals(result, num1+num2);
    }

    /**
     * DataProvider с тестовыми данными и ожидаемым результатом для тестов (вычитание)
     *
     * @return двумерный массив объектовый (стандартный return для DataProvider)
     */
    @DataProvider
    public Object[][] testAndExpectedSubtractionPositiveData(){
        return new Integer[][]{
                {500, 60, 440},
                {224, 7, 217},
                {65, 5, 60}
        };
    }

    /**
     * Параметризированный тест для вычитания
     * @param num1 тестовые данные
     * @param num2 тестовые данные
     * @param result результат
     */
    @Test(dataProvider = "testAndExpectedSubtractionPositiveData")
    public void testSubtractionDataProvider(int num1, int num2, int result){
        calculator.subtraction(num1,num2);
        Assert.assertEquals(result, num1-num2);
    }

    /**
     * DataProvider с тестовыми данными и ожидаемым результатом для тестов (умножение)
     *
     * @return двумерный массив объектовый (стандартный return для DataProvider)
     */
    @DataProvider
    public Object[][] testAndExpectedMultiplicationPositiveData(){
        return new Integer[][]{
                {50, 6, 300},
                {2, 7, 14},
                {5, 5, 25}
        };
    }

    /**
     * Параметризированный тест для умножения
     * @param num1 тестовые данные
     * @param num2 тестовые данные
     * @param result результат
     */
    @Test(dataProvider = "testAndExpectedMultiplicationPositiveData")
    public void testMultiplicationDataProvider(int num1, int num2, int result){
        calculator.multiplication(num1,num2);
        Assert.assertEquals(result, num1*num2);
    }

    /**
     * DataProvider с тестовыми данными и ожидаемым результатом для тестов (деление)
     *
     * @return двумерный массив объектовый (стандартный return для DataProvider)
     */
    @DataProvider
    public Object[][] testAndExpectedDivisionPositiveData(){
        return new Integer[][]{
                {50, 5, 10},
                {210, 7, 30},
                {5, 5, 1}
        };
    }

    /**
     * Параметризированный тест для деления
     * @param num1 тестовые данные
     * @param num2 тестовые данные
     * @param result результат
     */
    @Test(dataProvider = "testAndExpectedDivisionPositiveData")
    public void testDivisionDataProvider(int num1, int num2, int result){
        calculator.division(num1,num2);
        Assert.assertEquals(result, num1/num2);
    }

    /**
     * DataProvider с тестовыми данными и ожидаемым результатом для тестов (сложение)
     *
     * @return двумерный массив объектовый (стандартный return для DataProvider)
     */
    @DataProvider
    public Object[][] testAndExpectedAdditionNegativeData(){
        return new Integer[][]{
                {240, 760, 100},
                {24, 7, 310},
                {65, 5, 71}
        };
    }

    /**
     * Негативный параметризированный тест для деления
     * @param num1 тестовые данные
     * @param num2 тестовые данные
     * @param result результат
     */
    @Test(dataProvider = "testAndExpectedAdditionNegativeData")
    public void testAdditionDataProviderNegative(int num1, int num2, int result){
        calculator.addition(num1,num2);
        Assert.assertEquals(result, num1+num2);
    }
}