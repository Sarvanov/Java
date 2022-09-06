package steps;

import dto.PetModel;
import io.restassured.specification.RequestSpecification;
import utils.ResponseWrapper;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static utils.TestDataHelper.*;

/**
 * Класс с реализацией всех Rest шагов
 */
public class Steps {

    /**
     * Экземпляр спецификации Rest Assured
     */
    private final RequestSpecification requestSpecification;

    /**
     * Часть URL для /pet
     */
    private static final String PET_PATH = "pet";

    /**
     * Параметр id для get запроса getById
     */
    private static String ID_PARAMETER = "id";

    /**
     * Конструктор для создания экземпляра класса
     *
     * @param requestSpecification спецификация Rest Assured
     */
    public Steps(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    /**
     * Метод создания животного
     *
     * @param request тело запроса
     * @return оболочка для работы с ответом
     */
    public ResponseWrapper createNewPetToStore(PetModel request) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .body(request)
                .post(PET_PATH)
                .andReturn());
    }

    public ResponseWrapper updateAnExistingPet(PetModel request) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .body(request)
                .put(PET_PATH)
                .andReturn());
    }

    public ResponseWrapper getPetById(String id) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .basePath(PET_PATH + "/")
                .get(id)
                .andReturn());
    }

    public ResponseWrapper deletesAPetById(String request) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
//                .body(request)
                .basePath(PET_PATH + "/")
                .delete(request)
                .andReturn());
    }
}