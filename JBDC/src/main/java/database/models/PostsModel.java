package database.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * Модель-сущность posts для базы данных
 */
@Data
@Builder
@EqualsAndHashCode(exclude = {"id"})
public class PostsModel {

    private final int id;
    private final int user_id;
    private final String title;
    private final String post_text;
    private final LocalDate post_date;
}
