package database.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * Модель-сущность users для базы данных
 */
@Data
@Builder
@EqualsAndHashCode(exclude = {"id"})
public class UsersModel {

   private final int id;
   private final String nickName;
   private final String email;
   private final String password;
   private final LocalDate birthDate;
   private final boolean isMale;
}
