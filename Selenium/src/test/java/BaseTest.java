import config.BaseConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static utils.ScreenHelper.makeScreenshot;

/**
 * ����� ����� � ����������� ��� ���� ������
 */
public class BaseTest {

    /**
     * ���������� � ����������� ��������
     */
    protected WebDriver driver;

    /**
     * ��������� ������������ � ������ �����������
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * ����� ��������� ��� ���� ������ ����� ����������� �������
     */
    @BeforeMethod
    public void setUp(){
        //��������� ��������� � ����� � Google ��������
        System.setProperty(config.driverProperty(),config.driverPath());

        // �������� ���������� ��������
        driver = new ChromeDriver();

        // �������� �������� �� URL
        driver.get(config.url());

        // �������� �������� �� ������ ����
        driver.manage().window().maximize();

        // �������� ���������
        makeScreenshot(driver);

        //������� �������� �� ��������� 5 ������
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    /**
     * ����� ��������� ��� ���� ������ ����� ���������� �������
     */
    @AfterMethod
    public void tearDown(){

        // ��������� ������ ��������
        driver.close();
    }
}