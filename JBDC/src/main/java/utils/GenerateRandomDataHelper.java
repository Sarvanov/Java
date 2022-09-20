package utils;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

/**
 * ����� � �������� �������� ��������� ������
 */
@UtilityClass
public class GenerateRandomDataHelper {

    private static final Faker faker = new Faker();

    private static final String EMAIL_REGEXP = "[a-z]{10}\\@[a-z]{5}\\.[a-z]{2}";

    private static final String PASSWORD_REGEXP = "[A-Za-z0-9]{8}";

    /**
     * ����� ��������� ���������� nickname
     *
     * @return ��������� �������
     */
    public static String getRandomNickName() {
        return faker.name().username();
    }

    /**
     * ����� ��������� ���������� email
     *
     * @return ��������� email
     */
    public static String getRandomEmail() {
        return faker.regexify(EMAIL_REGEXP);
    }

    /**
     * ����� ��������� ���������� ������
     *
     * @return ��������� ������
     */
    public static String getRandomPassword() {
        return faker.regexify(PASSWORD_REGEXP);
    }

    /**
     * ����� ��������� ��������� ���� ��������
     *
     * @return ��������� ���� ��������
     */
    public static LocalDate getRandomBirthDate() {
        int year = faker.number().numberBetween(1930, 2010);
        int month = faker.number().numberBetween(1, 12);
        int day = faker.number().numberBetween(1, 28);
        return LocalDate.of(year, month, day);
    }

    /**
     * ����� ��������� ���������� ����
     *
     * @return ��������� ���
     */
    public static boolean getRandomSex() {
        return faker.random().nextBoolean();
    }

    /**
     * ����� ��������� ���������� ���������
     *
     * @return ��������� ���������
     */
    public static String getRandomTitle() {
        return faker.hipster().word();
    }

    /**
     * ����� ��������� ���������� ������
     *
     * @return ��������� �����
     */
    public static String getRandomPostText() {
        return faker.color().name();
    }

    /**
     * ����� ��������� ��������� ����
     *
     * @return ��������� ����
     */
    public static LocalDate getRandomPostDate() {
        int year = faker.number().numberBetween(2021, 2022);
        int month = faker.number().numberBetween(1, 12);
        int day = faker.number().numberBetween(1, 28);
        return LocalDate.of(year, month, day);
    }
}