package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * ����� � �������� ������ ��������
 */
public class Waiters {

    /**
     * �������� � ������� 5 ������ ��������� �������� �� ��������
     * @param driver ��������� �������� ��������
     * @param element �������
     */
    public static void waitUntilVisible(final WebDriver driver, WebElement element) {

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
    }
}
