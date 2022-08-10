import config.AvitoTestsConfig;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;
import pages.AvitoPage;

/**
 * Основной класс с тестами AvitoPage
 */
@Epic("Avito")
public class AvitoTest extends BaseTest {

    /**
     * Экземпляр конфигурации с параметрами для Avito тестов
     */
    private final AvitoTestsConfig config = ConfigFactory.create(AvitoTestsConfig.class, System.getenv());

    @Test (description = "Вывод в консоль цен первый 5 самых дорогих товаров по поиску")
    @Feature("Вывод результатов поиска")
    public void testAvitoSearch() {

        // Создание объекта
        AvitoPage avitoPage = new AvitoPage(driver);

        // Вызовы методов у объекта
        avitoPage.clickYet();
        avitoPage.clickChooseCategory();
        avitoPage.inputStringInSearchField(config.inputSearchGood());
        avitoPage.clickOnlyWithPhoto();
        avitoPage.clickListOfRegions();
        avitoPage.inputStringInSearchCity(config.inputSearchCity());
        avitoPage.clickChooseRegion();
        avitoPage.clickCountAds();
        avitoPage.clickSortList();
        avitoPage.clickExpencive()
                .printFirstPriceSpecifiedNumber(5);
    }
}