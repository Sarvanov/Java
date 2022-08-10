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
 * �����, � ������� ���������� �������������� �� ��������� �����
 */
public class AvitoPage {

    /**
     * ��������� �������� ��� ���������� ���������
     */
    private final WebDriver driver;

    /**
     * ��������� ������������ � ����������� ��� ����� ������
     */
    private final AvitoTestsConfig config = ConfigFactory.create(AvitoTestsConfig.class, System.getenv());

    /**
     * ������� "���" ��� ��������� ���� ���������
     */
    @FindBy(css = "span[class= 'top-rubricator-more-G5sAi text-text-LurtD text-size-s-BxGpL']")
    private WebElement yet;

    /**
     * ��������� "���������� � ����������"
     */
    @FindBy(css = "a[href='/penza/orgtehnika_i_rashodniki?cd=1']")
    private WebElement chooseCategory;

    /**
     * ������� ��� ����� �������� ������ � ���� ������
     */
    @FindBy(css = "input[data-marker='search-form/suggest']")
    private WebElement searchField;

    /**
     * ���-���� "������ � ����"
     */
    @FindBy(xpath = "//*[text()='������ � ����']")
    private WebElement onlyWithPhoto;

    /**
     * ���������� ������ ��� ������ �������
     */
    @FindBy(css = "div[data-marker='search-form/region']")
    private WebElement listOfRegions;

    /**
     * ������� ��� ����� ������� � ���� ������
     */
    @FindBy(css = "input[data-marker='popup-location/region/input']")
    private WebElement inputCity;

    /**
     * ����� ������������ ������� ����� ����� � ���� ������
     */
    @FindBy(css = "li[data-marker='suggest(0)']")
    private WebElement chooseRegion;

    /**
     * ������ "�������� n ����������"
     */
    @FindBy(css = "button[class='button-button-CmK9a button-size-m-LzYrF button-primary-x_x8w']")
    private WebElement countAds;

    /**
     * ���������� �������
     */
    @FindBy(css = "div[class='select-select-box-jJiQW select-size-s-VX5kS']")
    private WebElement sortList;

    /**
     * "������" � ������ ���������� �������
     */
    @FindBy(xpath = "//*[text()='������']")
    private WebElement expencive;

    /**
     * ����������� �������� AvitoPage
     *
     * @param driver - ������� ��� ���������� ���������
     */
    public AvitoPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * ����� ������� �� ������ "���" ��� ��������� ���� ���������
     *
     * @return ������� ��������
     */
    @Step("������� �� ������ ���")
    public AvitoPage clickYet() {
        yet.click();
        makeScreenshot(driver);
        return this;
    }

    /**
     * ����� ������ ��������� "���������� � ����������"
     *
     * @return ������� ��������
     */
    @Step("����� ���������")
    public AvitoPage clickChooseCategory() {
        chooseCategory.click();
        makeScreenshot(driver);
        return this;
    }

    /**
     * ����� ��� ����� �������� ������ � ���� ������
     *
     * @param str ����� �����
     * @return ������� ��������
     */
    @Step("����� ������ �� ������")
    public AvitoPage inputStringInSearchField(String str) {
        searchField.sendKeys(str);
        makeScreenshot(driver);
        return this;
    }

    /**
     * ����� ��������� ���-����� "������ � ����"
     *
     * @return ������� ��������
     */
    @Step("��������� ���-�����")
    public AvitoPage clickOnlyWithPhoto() {
        onlyWithPhoto.click();
        makeScreenshot(driver);
        return this;
    }

    /**
     * ����� ��� ��������� ������ ��������
     *
     * @return ������� ��������
     */
    @Step("��������� ������ ��������")
    public AvitoPage clickListOfRegions() {
        listOfRegions.click();
        makeScreenshot(driver);
        return this;
    }

    /**
     * ����� ����� ������ � ���� ������ ��������
     *
     * @param str ����� �����
     * @return ������� ��������
     */
    @Step("����� ������� �� ������")
    public AvitoPage inputStringInSearchCity(String str) {
        waitUntilVisible(driver, inputCity);
        inputCity.sendKeys(str);
        waitUntilVisible(driver, inputCity);
        makeScreenshot(driver);
        return this;
    }

    /**
     * ����� ������ ������������ ������� �� ������������� ����� ����� � ���� ������
     *
     * @return ������� ��������
     */
    @Step("����� ������� �� ������������ ��������� ����� ����� � ���� ������")
    public AvitoPage clickChooseRegion() {
        waitUntilVisible(driver, chooseRegion);
        makeScreenshot(driver);
        chooseRegion.click();
        makeScreenshot(driver);
        return this;
    }

    /**
     * ����� ������� �� ����� ���������� ����������
     *
     * @return ������� ��������
     */
    @Step("���� �� ������ ���������� ����������")
    public AvitoPage clickCountAds() {
        waitUntilVisible(driver, countAds);
        countAds.click();
        makeScreenshot(driver);
        return this;
    }

    /**
     * ����� ������ ���������� �������
     *
     * @return ������� ��������
     */
    @Step("���������� �������")
    public AvitoPage clickSortList() {
        sortList.click();
        makeScreenshot(driver);
        return this;
    }

    /**
     * ����� ������ "������" � ���������� ������
     *
     * @return ������� ��������
     */
    @Step("����� ���������� �� �������� ����")
    public AvitoPage clickExpencive() {
        expencive.click();
        makeScreenshot(driver);
        return this;
    }

    /**
     * ����� ������ ��� n-��� ���������� �������
     *
     * @param count ���������� �������
     */
    @Step("������ � ������� ��� ����� ������� �������")
    public void printFirstPriceSpecifiedNumber(int count) {
        for (int i = 1; i <= count; i++) {
            System.out.println(getSearchResultElementByNumber(i).getAttribute(config.linkAttribute()));
        }
    }

    /**
     * ����� ��������� ���� ������ �� ������
     *
     * @param elementNumber ����� ��������
     * @return ������� ���������� ������
     */
    private WebElement getSearchResultElementByNumber(int elementNumber) {
        return driver.findElement(By.xpath("//*[@class='items-items-kAJAg']/div[" + elementNumber + "]/div/div/div//meta[2]"));
    }
}