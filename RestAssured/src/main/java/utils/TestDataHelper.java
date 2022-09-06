package utils;

import com.github.javafaker.Faker;

public class TestDataHelper {

    /**
     * Валидный идентификатор питомца
     */
    public static final String VALID_PET_ID = "1000";

    /**
     * Невалидный идентификатор питомца
     */
    public static final String NOT_VALID_PET_ID = "Hello";

    /**
     * Валидный идентификатор категории
     */
    public static final int VALID_CATEGORY_ID = 0;

    /**
     * Валидный идентификатор тега
     */
    public static final int VALID_TAG_ID = 0;

    /**
     * Валидное имя тега
     */
    public static final String VALID_TAG_NAME = "tagOne";

    /**
     * Валидный статус питомца
     */
    public static final String VALID_STATUS = "available";

    /**
     * Статус код успешного результата запроса
     */
    public static final int STATUS_CODE_OK = 200;

    /**
     * Статус код неуспешного результата запроса
     */
    public static final int STATUS_CODE_ERROR_500 = 500;

    /**
     * Статус код неуспешного результата запроса
     */
    public static final int STATUS_CODE_ERROR_404 = 404;

    /**
     * Экземпляр класса Faker
     */
    private static final Faker faker = new Faker();

    /**
     * Регулярное выражение для генерации случайного URL
     */
    private static final String REGEXP_PHOTO_URL = "http:\\\\[a-z]{5}.ru";

    /**
     * Метод получения случайного имени питомца
     * @return случайное имя питомца
     */
    public static String getRandomPetName() {
        return faker.dog().name();
    }

    /**
     * Метод получения случайного имени категории
     * @return случайное имя категории
     */
    public static String getRandomCategoryName() {
        return faker.dog().breed();
    }

    /**
     * Метод получения случайного URL
     * @return случайное URL
     */
    public static String getRandomUrl() {
        return faker.regexify(REGEXP_PHOTO_URL);
    }
}