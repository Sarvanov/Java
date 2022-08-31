package helper;

import com.github.javafaker.Faker;

public class Helper {

    /**
     * Ёкземпл€р класса Faker
     */
    private final static Faker FAKER = new Faker();

    /**
     * –егул€рное выражение дл€ создани€ рандомного id
     * @return рандомный id
     */
    public static String getRandomId() {
        return FAKER.regexify("[0-9]{6}");
    }
}
