package helper;

import com.github.javafaker.Faker;

public class Helper {

    private final static Faker FAKER = new Faker();

    public static String getRandomId() {
        return FAKER.regexify("[0-9]{6}");
    }

//    public static String getRandomPetId() {
//        return FAKER.regexify("[0-9]{6}");
//    }
}
