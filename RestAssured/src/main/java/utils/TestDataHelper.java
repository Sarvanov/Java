package utils;

import com.github.javafaker.Faker;

public class TestDataHelper {

    /**
     * �������� ������������� �������
     */
    public static final String VALID_PET_ID = "1000";

    /**
     * ���������� ������������� �������
     */
    public static final String NOT_VALID_PET_ID = "Hello";

    /**
     * �������� ������������� ���������
     */
    public static final int VALID_CATEGORY_ID = 0;

    /**
     * �������� ������������� ����
     */
    public static final int VALID_TAG_ID = 0;

    /**
     * �������� ��� ����
     */
    public static final String VALID_TAG_NAME = "tagOne";

    /**
     * �������� ������ �������
     */
    public static final String VALID_STATUS = "available";

    /**
     * ������ ��� ��������� ���������� �������
     */
    public static final int STATUS_CODE_OK = 200;

    /**
     * ������ ��� ����������� ���������� �������
     */
    public static final int STATUS_CODE_ERROR_500 = 500;

    /**
     * ������ ��� ����������� ���������� �������
     */
    public static final int STATUS_CODE_ERROR_404 = 404;

    /**
     * ��������� ������ Faker
     */
    private static final Faker faker = new Faker();

    /**
     * ���������� ��������� ��� ��������� ���������� URL
     */
    private static final String REGEXP_PHOTO_URL = "http:\\\\[a-z]{5}.ru";

    /**
     * ����� ��������� ���������� ����� �������
     * @return ��������� ��� �������
     */
    public static String getRandomPetName() {
        return faker.dog().name();
    }

    /**
     * ����� ��������� ���������� ����� ���������
     * @return ��������� ��� ���������
     */
    public static String getRandomCategoryName() {
        return faker.dog().breed();
    }

    /**
     * ����� ��������� ���������� URL
     * @return ��������� URL
     */
    public static String getRandomUrl() {
        return faker.regexify(REGEXP_PHOTO_URL);
    }
}