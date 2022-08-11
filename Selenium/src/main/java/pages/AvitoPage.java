package pages;

import config.AvitoTestsConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.ScreenHelper.makeScreenshot;
import static utils.Waiters.waitUntilVisible;

/**
 * Класс, в котором происходит взаимодействие со страницей Авито
 */
public class AvitoPage {

    /**
     * Экземпляр драйвера для управления браузером
     */
    private final WebDriver driver;

    /**
     * Экземпляр конфигурации с параметрами для Авито тестов
     */
    private final AvitoTestsConfig config = ConfigFactory.create(AvitoTestsConfig.class, System.getenv());

    /**
     * Элемент "Ещё" для раскрытия всех категорий
     */
    @FindBy(css = "span[class= 'top-rubricator-more-G5sAi text-text-LurtD text-size-s-BxGpL']")
    private WebElement yet;

    /**
     * Категория "Оргтехника и расходники"
     */
    @FindBy(css = "a[href='/penza/orgtehnika_i_rashodniki?cd=1']")
    private WebElement chooseCategory;

    /**
     * Элемент для ввода названия товара в поле поиска
     */
    @FindBy(css = "input[data-marker='search-form/suggest']")
    private WebElement searchField;

    /**
     * Чек-бокс "Только с фото"
     */
    @FindBy(xpath = "//*[text()='только с фото']")
    private WebElement onlyWithPhoto;

    /**
     * Выпадающий список для выбора региона
     */
    @FindBy(css = "div[data-marker='search-form/region']")
    private WebElement listOfRegions;

    /**
     * Элемент для ввода региона в поле поиска
     */
    @FindBy(css = "input[data-marker='popup-location/region/input']")
    private WebElement inputCity;

    /**
     * Выбор необходимого региона после ввода в поле поиска
     */
    @FindBy(css = "li[data-marker='suggest(0)']")
    private WebElement chooseRegion;

    /**
     * Кнопка "Показать n объявлений"
     */
    @FindBy(css = "button[class='button-button-CmK9a button-size-m-LzYrF button-primary-x_x8w']")
    private WebElement countAds;

    /**
     * Сортировка товаров
     */
    @FindBy(css = "div[class='select-select-box-jJiQW select-size-s-VX5kS']")
    private WebElement sortList;

    /**
     * "Дороже" в списке сортировки товаров
     */
    @FindBy(xpath = "//*[text()='Дороже']")
    private WebElement expencive;

    /**
     * Конструктор создания AvitoPage
     *
     * @param driver - драйвер для управления браузером
     */
    public AvitoPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Метод нажатия на кнопку "Ещё" для раскрытия всех категорий
     *
     * @return текущая страница
     */
    @Step("Нажатие на кнопку Ещё")
    public AvitoPage clickYet() {
        yet.click();
        makeScreenshot(driver);
        return this;
    }

    /**
     * Метод выбора категории "Оргтехника и расходники"
     *
     * @return текущая страница
     */
    @Step("Выбор категории")
    public AvitoPage clickChooseCategory() {
        chooseCategory.click();
        makeScreenshot(driver);
        return this;
    }

    /**
     * Метод для ввода названия товара в поле поиска
     *
     * @param str текст ввода
     * @return текущая страница
     */
    @Step("Поиск товара по строке")
    public AvitoPage inputStringInSearchField(String str) {
        searchField.sendKeys(str);
        makeScreenshot(driver);
        return this;
    }

    /**
     * Метод активации чек-бокса "Только с фото"
     *
     * @return текущая страница
     */
    @Step("Активация чек-бокса")
    public AvitoPage clickOnlyWithPhoto() {
        onlyWithPhoto.click();
        makeScreenshot(driver);
        return this;
    }

    /**
     * Метод для раскрытия списка регионов
     *
     * @return текущая страница
     */
    @Step("Раскрытие списка регионов")
    public AvitoPage clickListOfRegions() {
        listOfRegions.click();
        makeScreenshot(driver);
        return this;
    }

    /**
     * Метод ввода текста в поле списка регионов
     *
     * @param str текст ввода
     * @return текущая страница
     */
    @Step("Поиск региона по строке")
    public AvitoPage inputStringInSearchCity(String str) {
        waitUntilVisible(driver, inputCity);
        inputCity.sendKeys(str);
        waitUntilVisible(driver, inputCity);
        makeScreenshot(driver);
        return this;
    }

    /**
     * Метод выбора необходимого региона из предложенного после ввода в поле поиска
     *
     * @return текущая страница
     */
    @Step("Выбор региона из предложенных вариантов после ввода в поле поиска")
    public AvitoPage clickChooseRegion() {
        waitUntilVisible(driver, chooseRegion);
        makeScreenshot(driver);
        chooseRegion.click();
        makeScreenshot(driver);
        return this;
    }

    /**
     * Метод нажатия на общее количество объявлений
     *
     * @return текущая страница
     */
    @Step("Клик по общему количеству объявлений")
    public AvitoPage clickCountAds() {
        waitUntilVisible(driver, countAds);
        countAds.click();
        makeScreenshot(driver);
        return this;
    }

    /**
     * Метод выбора сортировки товаров
     *
     * @return текущая страница
     */
    @Step("Сортировка товаров")
    public AvitoPage clickSortList() {
        sortList.click();
        makeScreenshot(driver);
        return this;
    }

    /**
     * Метод выбора "Дороже" в выпадающем списке
     *
     * @return текущая страница
     */
    @Step("Выбор сортировки по убыванию цены")
    public AvitoPage clickExpencive() {
        expencive.click();
        makeScreenshot(driver);
        return this;
    }

    /**
     * Метод печати цен n-ого количества товаров
     *
     * @param count количество товаров
     */
    @Step("Печать в консоль цен самых дорогих товаров")
    public void printFirstPriceSpecifiedNumber(int count) {
        for (int i = 1; i <= count; i++) {
            System.out.println(getSearchResultElementByNumber(i).getAttribute(config.linkAttribute()));
        }
    }

    /**
     * Метод получения цены товара по номеру
     *
     * @param elementNumber номер элемента
     * @return элемент результата поиска
     */
    private WebElement getSearchResultElementByNumber(int elementNumber) {
        return driver.findElement(By.xpath("//*[@class='items-items-kAJAg']/div[" + elementNumber + "]/div/div/div//meta[2]"));
    }
}