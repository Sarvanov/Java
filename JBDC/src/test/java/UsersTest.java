import database.models.UsersModel;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static utils.TestObjectBuilder.getRandomUsersModel;

public class UsersTest extends BaseTest {

    /**
     * Модель объекта Users
     */
    private UsersModel users;

    /**
     * Переменная id
     */
    private int id;

    @Test
    @Epic("Users")
    @Owner("Aleksey Sarvanov")
    @DisplayName("Test for Users")
    public void testUsers() {
        Allure.step("Шаг 1: Создать в БД users нового пользователя", () -> {
            users = getRandomUsersModel();
            steps.createUsers(users);

            List<UsersModel> list = steps.getAllUsers();
            for (UsersModel element : list) {
                if (element.getNickName().equals(users.getNickName())) {
                    assertThat(element).isEqualTo(users);
                    id = element.getId();
                    System.out.println(id);
                }
            }
        });

        Allure.step("Шаг 2: Получить из БД users созданного нового пользователя по id", () -> {
            UsersModel actualUser = steps.getUsersById(id);
            assertThat(actualUser).isEqualTo(users);
            System.out.println(actualUser.toString());
        });

        Allure.step("Шаг 3: Обновить созданного пользователя", () -> {
            users = getRandomUsersModel();

            List<UsersModel> list = steps.getAllUsers();
            for (UsersModel element : list) {
                if (element.getNickName().equals(users.getNickName())) {
                    id = element.getId();
                }
            }

            users = getRandomUsersModel();
            steps.updateUsers(users, id);
        });

        Allure.step("Шаг 4: Получить из БД users обновленного пользователя по его id", () -> {
            UsersModel actualUser = steps.getUsersById(id);
            assertThat(actualUser).isEqualTo(users);
            System.out.println(actualUser.toString());
        });

        Allure.step("Шаг 5: Удалить пользователя по его id", () -> {
            steps.deleteUser(id);
        });

        Allure.step("Шаг 6: Получить удаленного пользователя по его id", () -> {
            UsersModel actualUser = steps.getUsersById(id);
            assertThat(actualUser).isNull();
        });
    }
}