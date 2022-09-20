package utils;

import database.models.UsersModel;
import lombok.experimental.UtilityClass;

import static utils.GenerateRandomDataHelper.*;

/**
 * Класс с методом создания тестовых объектов
 */
@UtilityClass
public class TestObjectBuilder {

    /**
     * Метод генерации случайной Users модели
     * @return случайная Users модель
     */
    public static UsersModel getRandomUsersModel() {
        return UsersModel.builder()
                .nickName(getRandomNickName())
                .email(getRandomEmail())
                .password(getRandomPassword())
                .birthDate(getRandomBirthDate())
                .isMale(getRandomSex())
                .build();
    }
}