import config.BaseConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static utils.ScreenHelper.makeScreenshot;

/**
 * Общий класс с настройками для всех тестов
 */
public class BaseTest {

    /**
     * Переменная с экземпляром драйвера
     */
    protected WebDriver driver;

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Общие настройки для всех тестов перед выполнением каждого
     */
    @BeforeMethod
    public void setUp(){
        //Установка настройки с путем к Google драйверу
        System.setProperty(config.driverProperty(),config.driverPath());

        // Создание экземпляра драйвера
        driver = new ChromeDriver();

        // Открытие страницы по URL
        driver.get(config.url());

        // Разворот страницы на полное окно
        driver.manage().window().maximize();

        // Создание скриншота
        makeScreenshot(driver);

        //Неявное ожидание по умолчанию 5 секунд
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    /**
     * Общие настройки для всех тестов после выполнения каждого
     */
    @AfterMethod
    public void tearDown(){

        // Остановка работы драйвера
        driver.close();
    }
}