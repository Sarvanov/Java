import database.models.PostsModel;
import database.models.UsersModel;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BodyGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.GenerateRandomDataHelper.*;
import static utils.TestObjectBuilder.getRandomUsersModel;

public class PostsTest extends BaseTest {

    /**
     * ������ ������� Users
     */
    private UsersModel users;

    /**
     * ������ ������� Posts
     */
    private PostsModel posts;

    /**
     * ��������� ������ ��� ���������� Posts
     */
    private PostsModel updatePosts;

    /**
     * ���������� user_id
     */
    private int user_id;
    private int id;

    @Test
    @Epic("Posts")
    @Owner("Aleksey Sarvanov")
    @DisplayName("Test for Posts")
    public void testPosts() {
        Allure.step("��� 1: ������� � �� users ������ ������������", () -> {
            users = getRandomUsersModel();

            steps.createUsers(users);

            List<UsersModel> list = steps.getAllUsers();
            for (UsersModel element : list) {
                if (element.getNickName().equals(users.getNickName())) {
                    assertThat(element)
                            .isEqualTo(users);
                    user_id = element.getId();
                    System.out.println(user_id);
                }
            }
        });

        Allure.step("��� 2: ������� � �� posts ����� post", () -> {
            posts = BodyGenerator.postBody(user_id, getRandomTitle(), getRandomPostText(), getRandomPostDate());
            System.out.println(posts.toString());
            steps.createPosts(posts);

            List<PostsModel> list = steps.getAllPosts();
            for (PostsModel element : list) {
                if (element.getTitle().equals(posts.getTitle())) {
                    assertThat(element)
                            .isEqualTo(posts);
                    id = element.getId();
                }
            }
        });

        Allure.step("��� 3: �������� �� �� posts ��������� post �� ��� id", () -> {
            PostsModel actualPost = steps.getPostsById(id);
            System.out.println(id);
            System.out.println(actualPost.toString());
        });

        Allure.step("��� 4: �������� ��������� post", () -> {
            updatePosts = BodyGenerator.postBody(posts.getUser_id(), "Telegram", posts.getPost_text(), posts.getPost_date());
            System.out.println(updatePosts.toString());
            steps.updatePosts(updatePosts, id);
        });

        Allure.step("��� 5: �������� �� �� posts ����������� post �� ��� id", () -> {
            PostsModel actualPost = steps.getPostsById(id);
            System.out.println(actualPost.toString());
        });

        Allure.step("��� 6: ������� post �� ��� id", () -> {
            steps.deletePost(id);
        });

        Allure.step("��� 7: �������� post �� ��� id", () -> {
            PostsModel actualPost = steps.getPostsById(id);
            assertThat(actualPost).isNull();
        });
    }
}