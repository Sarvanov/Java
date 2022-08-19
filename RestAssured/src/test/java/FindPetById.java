import base.BaseTest;
import dto.PetModel;
import dto.response.ErrorResponse;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static utils.ExpectedObjectBuilder.getUnknownErrorResponse;
import static utils.TestDataHelper.*;
import static utils.TestObjectBuilder.getAddNewPetModel;

/**
 * Тест-сьют метода GET /pet/getPetById
 */
@Epic("Pet контроллер")
@Feature("Find pet by ID")
public class FindPetById extends BaseTest {

    @Test
    @DisplayName("Find pet by ID. Positive case")
    @Story("Поиск питомца по ID. Позитивный сценарий")
    public void testFindPetByIdPositive() {
        step("Создание тела запроса с валидным ID", () -> {
            request = getAddNewPetModel(VALID_PET_ID);
        });

        step("Выполнение запроса POST /pet", () -> {
            responseWrapper = steps.createNewPetToStore(request);
        });

        step("Выполнение запроса GET /pet", () -> {
            responseWrapper = steps.getPetById(VALID_PET_ID);
        });

        step("Проверка результата", () -> {
            int statusCode = responseWrapper.getStatusCode();
            PetModel response = responseWrapper.as(PetModel.class);

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_OK);
                        softAssertions
                                .assertThat(response)
                                .withFailMessage("Response body doesn't match")
                                .isEqualTo(request);
                    }
            );
        });
    }

    @Test
    @DisplayName("Find pet by ID. Negative case")
    @Story("Поиск питомца по ID. Негативный сценарий")
    public void testFindPetByIdNegative() {
        step("Создание тела запроса с невалидным ID", () -> {
            request = getAddNewPetModel(NOT_VALID_PET_ID);
        });

        step("Выполнение запроса POST /pet", () -> {
            responseWrapper = steps.createNewPetToStore(request);
        });

        step("Выполнение запроса GET /pet", () -> {
            responseWrapper = steps.getPetById(NOT_VALID_PET_ID);
        });

        step("Проверка результата", () -> {
            int statusCode = responseWrapper.getStatusCode();
            ErrorResponse error = responseWrapper.as(ErrorResponse.class);

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_ERROR_404);
                        softAssertions
                                .assertThat(error)
                                .withFailMessage("Error body doesn't match")
                                .isNotEqualTo(request);
                    }
            );
        });
    }
}