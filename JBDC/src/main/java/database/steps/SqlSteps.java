package database.steps;

import database.models.PostsModel;
import database.models.UsersModel;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс с реализацией SQL шагов
 */
@AllArgsConstructor
public class SqlSteps {

    private static final String ID_FIELD = "id";
    private static final String NICKNAME_FIELD = "nickname";
    private static final String EMAIL_FIELD = "email";
    private static final String PASSWORD_FIELD = "password";
    private static final String BIRTHDATE_FIELD = "birthdate";
    private static final String IS_MALE_FIELD = "is_male";
    private static final String USER_ID_FIELD = "user_id";
    private static final String TITLE_FIELD = "title";
    private static final String POST_TEXT_FIELD = "post_text";
    private static final String POST_DATE_FIELD = "post_date";

    private static final String INSERT_SQL_QUERY = "INSERT INTO users (%s, %s, %s, %s, %s)" +
            "VALUES (\"%s\", \"%s\", \"%s\", \"%s\", %b)";

    private static final String UPDATE_SQL_REQUEST = "UPDATE users " +
            "SET %s = \"%s\", %s = \"%s\", %s = \"%s\", %s = \"%s\", %s = %b " +
            "WHERE %s = %d";

    private static final String DELETE_SQL_REQUEST = "DELETE FROM users WHERE %s = %d";

    private static final String SELECT_ALL_SQL_REQUEST = "SELECT * FROM users";
    private static final String SELECT_BY_ID_SQL_REQUEST = "SELECT * FROM users WHERE %s = %d";

    private static final String INSERT_POSTS_SQL_QUERY = "INSERT INTO posts (%s, %s, %s, %s)" +
            "VALUES (\"%s\", \"%s\", \"%s\", \"%s\")";

    private static final String SELECT_ALL_POSTS_SQL_REQUEST = "SELECT * FROM posts";

    private static final String UPDATE_POSTS_SQL_REQUEST = "UPDATE posts " +
            "SET %s = \"%s\", %s = \"%s\", %s = \"%s\",  %s = \"%s\"" +
            "WHERE %s = %d";

    private static final String SELECT_POSTS_BY_ID_SQL_REQUEST = "SELECT * FROM posts WHERE %s = %d";

    private static final String DELETE_POSTS_SQL_REQUEST = "DELETE FROM posts WHERE %s = %d";

    /**
     * Переменная с подключением к базе данных
     */
    private final Connection connection;

    /**
     * Метод создания users в БД
     *
     * @param users объект с параметрами для создания
     */
    public void createUsers(UsersModel users) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(String.format(INSERT_SQL_QUERY,
                    NICKNAME_FIELD, EMAIL_FIELD, PASSWORD_FIELD, BIRTHDATE_FIELD, IS_MALE_FIELD,
                    users.getNickName(), users.getEmail(), users.getPassword(), users.getBirthDate(), users.isMale()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод обновления users в БД
     *
     * @param users объект с параметрами для обновления
     * @param id идентификатор поля, которое обновляем
     */
    public void updateUsers(UsersModel users, int id) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(String.format(UPDATE_SQL_REQUEST,
                    NICKNAME_FIELD, users.getNickName(),
                    EMAIL_FIELD, users.getEmail(),
                    PASSWORD_FIELD, users.getPassword(),
                    BIRTHDATE_FIELD, users.getBirthDate(),
                    IS_MALE_FIELD, users.isMale(),
                    ID_FIELD, id)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод удаления user из БД
     *
     * @param id идентификатор поля, которое удаляем
     */
    public void deleteUser(int id) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(String.format(DELETE_SQL_REQUEST, ID_FIELD, id)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод запроса всех Users из БД
     *
     * @return список всех Users
     */
    public List<UsersModel> getAllUsers() {
        List<UsersModel> list = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(SELECT_ALL_SQL_REQUEST);
            while (result.next()) {
                list.add(UsersModel.builder()
                        .id(result.getInt(ID_FIELD))
                        .nickName(result.getString(NICKNAME_FIELD))
                        .email(result.getString(EMAIL_FIELD))
                        .password(result.getString(PASSWORD_FIELD))
                        .birthDate(result.getObject(BIRTHDATE_FIELD, LocalDate.class))
                        .isMale(result.getBoolean(IS_MALE_FIELD))
                        .build()
                );
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
    }

    /**
     * Метод запроса users по ID из БД
     *
     * @param id идентификатор поля
     * @return объект users
     */
    public UsersModel getUsersById(int id) {
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(String.format(SELECT_BY_ID_SQL_REQUEST, ID_FIELD, id));
            if (result.next()) {
                return UsersModel.builder()
                        .id(result.getInt(ID_FIELD))
                        .nickName(result.getString(NICKNAME_FIELD))
                        .email(result.getString(EMAIL_FIELD))
                        .password(result.getString(PASSWORD_FIELD))
                        .birthDate(result.getObject(BIRTHDATE_FIELD, LocalDate.class))
                        .isMale(result.getBoolean(IS_MALE_FIELD))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Метод создания posts в БД
     * @param posts объект с параметрами для создания
     */
    public void createPosts(PostsModel posts) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(String.format(INSERT_POSTS_SQL_QUERY,
                    USER_ID_FIELD, TITLE_FIELD, POST_TEXT_FIELD, POST_DATE_FIELD,
                    posts.getUser_id(), posts.getTitle(), posts.getPost_text(), posts.getPost_date()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод запроса всех posts из БД
     * @return список всех posts
     */
    public List<PostsModel> getAllPosts() {
        List<PostsModel> list = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(SELECT_ALL_POSTS_SQL_REQUEST);
            while (result.next()) {
                list.add(PostsModel.builder()
                        .id(result.getInt(ID_FIELD))
                        .user_id(result.getInt(USER_ID_FIELD))
                        .title(result.getString(TITLE_FIELD))
                        .post_text(result.getString(POST_TEXT_FIELD))
                        .post_date(result.getObject(POST_DATE_FIELD, LocalDate.class))
                        .build()
                );
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
    }

    /**
     * Метод обновления posts
     * @param posts объект с параметрами для обновления
     * @param id идентификатор для обновления
     */
    public void updatePosts(PostsModel posts, int id) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(String.format(UPDATE_POSTS_SQL_REQUEST,
                    USER_ID_FIELD, posts.getUser_id(),
                    TITLE_FIELD, posts.getTitle(),
                    POST_TEXT_FIELD, posts.getPost_text(),
                    POST_DATE_FIELD, posts.getPost_date(),
                    ID_FIELD, id)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод запроса posts по id
     * @param id идентификатор поля
     * @return объект posts
     */
    public PostsModel getPostsById(int id) {
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(String.format(SELECT_POSTS_BY_ID_SQL_REQUEST, ID_FIELD, id));
            if (result.next()) {
                return PostsModel.builder()
                        .id(result.getInt(ID_FIELD))
                        .user_id(result.getInt(USER_ID_FIELD))
                        .title(result.getString(TITLE_FIELD))
                        .post_text(result.getString(POST_TEXT_FIELD))
                        .post_date(result.getObject(POST_DATE_FIELD, LocalDate.class))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Метод удаления posts из БД
     * @param id идентификатор поля
     */
    public void deletePost(int id) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(String.format(DELETE_POSTS_SQL_REQUEST, ID_FIELD, id)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}