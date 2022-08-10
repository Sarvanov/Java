package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * ����� � �������� ������ �� �����������
 */
public class ScreenHelper {

    /**
     * ����� ������ �������� ��� allure ������
     *
     * @param driver ��������� ��������
     */
    @Attachment
    public static byte[] makeScreenshot(WebDriver driver) {
        Screenshot screenshot = new AShot().takeScreenshot(driver);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            ImageIO.write(screenshot.getImage(), "PNG", buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toByteArray();
    }
}