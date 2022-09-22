package utils;

import database.models.UsersModel;
import lombok.experimental.UtilityClass;

import static utils.GenerateRandomDataHelper.*;

/**
 * ����� � ������� �������� �������� ��������
 */
@UtilityClass
public class TestObjectBuilder {

    /**
     * ����� ��������� ��������� Users ������
     * @return ��������� Users ������
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