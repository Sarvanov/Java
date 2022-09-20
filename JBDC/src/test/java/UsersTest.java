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
     * ������ ������� Users
     */
    private UsersModel users;

    /**
     * ���������� id
     */
    private int id;

    @Test
    @Epic("Users")
    @Owner("Aleksey Sarvanov")
    @DisplayName("Test for Users")
    public void testUsers() {
        Allure.step("��� 1: ������� � �� users ������ ������������", () -> {
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

        Allure.step("��� 2: �������� �� �� users ���������� ������ ������������ �� id", () -> {
            UsersModel actualUser = steps.getUsersById(id);
            assertThat(actualUser).isEqualTo(users);
            System.out.println(actualUser.toString());
        });

        Allure.step("��� 3: �������� ���������� ������������", () -> {
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

        Allure.step("��� 4: �������� �� �� users ������������ ������������ �� ��� id", () -> {
            UsersModel actualUser = steps.getUsersById(id);
            assertThat(actualUser).isEqualTo(users);
            System.out.println(actualUser.toString());
        });

        Allure.step("��� 5: ������� ������������ �� ��� id", () -> {
            steps.deleteUser(id);
        });

        Allure.step("��� 6: �������� ���������� ������������ �� ��� id", () -> {
            UsersModel actualUser = steps.getUsersById(id);
            assertThat(actualUser).isNull();
        });
    }
}