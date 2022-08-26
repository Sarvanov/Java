package steps;

import dto.PetModel;
import io.restassured.specification.RequestSpecification;
import utils.ResponseWrapper;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static utils.TestDataHelper.*;

/**
 * ����� � ����������� ���� Rest �����
 */
public class Steps {

    /**
     * ��������� ������������ Rest Assured
     */
    private final RequestSpecification requestSpecification;

    /**
     * ����� URL ��� /pet
     */
    private static final String PET_PATH = "pet";

    /**
     * �������� id ��� get ������� getById
     */
    private static String ID_PARAMETER = "id";

    /**
     * ����������� ��� �������� ���������� ������
     *
     * @param requestSpecification ������������ Rest Assured
     */
    public Steps(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    /**
     * ����� �������� ���������
     *
     * @param request ���� �������
     * @return �������� ��� ������ � �������
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