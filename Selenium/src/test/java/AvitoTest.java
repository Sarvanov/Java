import config.AvitoTestsConfig;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;
import pages.AvitoPage;

/**
 * �������� ����� � ������� AvitoPage
 */
@Epic("Avito")
public class AvitoTest extends BaseTest {

    /**
     * ��������� ������������ � ����������� ��� Avito ������
     */
    private final AvitoTestsConfig config = ConfigFactory.create(AvitoTestsConfig.class, System.getenv());

    @Test (description = "����� � ������� ��� ������ 5 ����� ������� ������� �� ������")
    @Feature("����� ����������� ������")
    public void testAvitoSearch() {

        // �������� �������
        AvitoPage avitoPage = new AvitoPage(driver);

        // ������ ������� � �������
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