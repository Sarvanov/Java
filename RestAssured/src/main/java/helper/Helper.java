package helper;

import com.github.javafaker.Faker;

public class Helper {

    /**
     * ��������� ������ Faker
     */
    private final static Faker FAKER = new Faker();

    /**
     * ���������� ��������� ��� �������� ���������� id
     * @return ��������� id
     */
    public static String getRandomId() {
        return FAKER.regexify("[0-9]{6}");
    }
}
