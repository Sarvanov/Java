package utils;

import database.models.PostsModel;

import java.time.LocalDate;

public class BodyGenerator {
    public static PostsModel postBody(int user_id, String title, String post_text, LocalDate post_date) {
        return PostsModel.builder()
                .user_id(user_id)
                .title(title)
                .post_text(post_text)
                .post_date(post_date)
                .build();
    }
}