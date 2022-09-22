package utils;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

/**
 *  ласс с методами создани€ рандомных данных
 */
@UtilityClass
public class GenerateRandomDataHelper {

    private static final Faker faker = new Faker();

    private static final String EMAIL_REGEXP = "[a-z]{10}\\@[a-z]{5}\\.[a-z]{2}";

    private static final String PASSWORD_REGEXP = "[A-Za-z0-9]{8}";

    /**
     * ћетод генерации случайного nickname
     *
     * @return случайную фамилию
     */
    public static String getRandomNickName() {
        return faker.name().username();
    }

    /**
     * ћетод генерации случайного email
     *
     * @return случайный email
     */
    public static String getRandomEmail() {
        return faker.regexify(EMAIL_REGEXP);
    }

    /**
     * ћетод генерации случайного парол€
     *
     * @return случайный пароль
     */
    public static String getRandomPassword() {
        return faker.regexify(PASSWORD_REGEXP);
    }

    /**
     * ћетод генерации случайной даты рождени€
     *
     * @return случайна€ дата рождени€
     */
    public static LocalDate getRandomBirthDate() {
        int year = faker.number().numberBetween(1930, 2010);
        int month = faker.number().numberBetween(1, 12);
        int day = faker.number().numberBetween(1, 28);
        return LocalDate.of(year, month, day);
    }

    /**
     * ћетод генерации случайного пола
     *
     * @return случайный пол
     */
    public static boolean getRandomSex() {
        return faker.random().nextBoolean();
    }

    /**
     * ћетод генерации случайного заголовка
     *
     * @return случайный заголовок
     */
    public static String getRandomTitle() {
        return faker.hipster().word();
    }

    /**
     * ћетод генерации случайного текста
     *
     * @return случайный текст
     */
    public static String getRandomPostText() {
        return faker.color().name();
    }

    /**
     * ћетод генерации случайной даты
     *
     * @return случайна€ дата
     */
    public static LocalDate getRandomPostDate() {
        int year = faker.number().numberBetween(2021, 2022);
        int month = faker.number().numberBetween(1, 12);
        int day = faker.number().numberBetween(1, 28);
        return LocalDate.of(year, month, day);
    }
}