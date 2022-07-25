package parametrized;

import exception.BadActionValue;
import exception.BadIntValue;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import validator.Validator;

/**
 * Набор тестов с DataProvider для класса Validator
 */
public class ValidatorDataProvider {

    /**
     * DataProvider с тестовыми данными для позитивных тестов по вводу целого числа
     *
     * @return двумерный массив объектовый (стандартный return для DataProvider)
     */
    @DataProvider
    public Object[][] getTestDataPositive() {
        return new String[][]{
                {"7"},
                {"50000"},
                {"999"},
        };
    }

    /**
     * DataProvider с тестовыми данными для негативных тестов
     *
     * @return двумерный массив объектовый (стандартный return для DataProvider)
     */
    @DataProvider
    public Object[][] getTestDataNegative() {
        return new String[][]{
                {"A"},
                {""},
                {"75.5"},
        };
    }

    /**
     * DataProvider с тестовыми данными для позитивных тестов по проверке ввода математического действия
     *
     * @return двумерный массив объектовый (стандартный return для DataProvider)
     */
    @DataProvider
    public Object[][] getTestActionValueDataPositive(){
        return new String[][]{
                {"+"},
                {"-"},
                {"*"},
                {"/"}
        };
    }

    /**
     * DataProvider с тестовыми данными для негативных тестов
     *
     * @return двумерный массив объектовый (стандартный return для DataProvider)
     */
    @DataProvider
    public Object[][] getTestActionValueDataNegative(){
        return new String[][]{
                {"+-"},
                {"5"},
                {""},
                {" "}
        };
    }

    /**
     * Параметризированный позитивный тест
     * @param num тестовые данные
     * @throws BadIntValue Добавление исключения в сигнатуру метода
     */
    @Test (dataProvider = "getTestDataPositive")
    public void testValidateInputIntPositive(String num) throws BadIntValue {
        String result = Validator.validateInputInt(num);
        Assert.assertEquals (result, num);
    }

    /**
     * Параметризированный негативный тест
     * @param num тестовые данные
     * @throws BadIntValue Добавление исключения в сигнатуру метода
     */
    @Test (dataProvider = "getTestDataNegative", expectedExceptions = BadIntValue.class)
    public void testValidateInputIntNegative(String num) throws BadIntValue {
        String result = Validator.validateInputInt(num);
        Assert.assertEquals (result, num);
    }

    /**
     * Параметризированный позитивный тест
     * @param inputAction тестовые данные
     * @throws BadActionValue Добавление исключения в сигнатуру метода
     */
    @Test (dataProvider = "getTestActionValueDataPositive")
    public void testValidateInputActionPositive(String inputAction) throws BadActionValue {
        String result = Validator.validateInputAction(inputAction);
        Assert.assertEquals (result, inputAction);
    }

    /**
     * Параметризированный негативный тест
     * @param inputAction тестовые данные
     * @throws BadActionValue Добавление исключения в сигнатуру метода
     */
    @Test (dataProvider = "getTestActionValueDataNegative", expectedExceptions = BadActionValue.class)
    public void testValidateInputActionNegative(String inputAction) throws BadActionValue {
        String result = Validator.validateInputAction(inputAction);
        Assert.assertEquals (result, inputAction);
    }
}