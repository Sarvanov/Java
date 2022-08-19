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
 * Тест-сьют метода PUT /pet/updatePet
 */
@Epic("Pet контроллер")
@Feature("Update an existing pet")
public class UpdateAnExistingPet extends BaseTest {

    @Test
    @DisplayName("Update an existing pet. Positive case")
    @Story("Обновление существующего питомца. Позитивный сценарий")
    public void testUpdateAnExistingPetPositive(){
        step("Создание тела запроса с валидным ID", () -> {
            request = getAddNewPetModel(VALID_PET_ID);
        });

        step("Выполнение запроса POST /pet", () -> {
            responseWrapper = steps.createNewPetToStore(request);
        });

        step("Выполнение запроса GET /pet", () -> {
            responseWrapper = steps.getPetById(VALID_PET_ID);
        });

        step("Создание тела запроса с валидным ID", () -> {
            request = getAddNewPetModel(VALID_PET_ID);
        });

        step("Выполнение запроса PUT /pet", () -> {
            responseWrapper = steps.updateAnExistingPet(request);
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
    @DisplayName("Update an existing pet. Negative case")
    @Story("Обновление существующего питомца. Негативный сценарий")
    public void testUpdateAnExistingPetNegative(){
        step("Создание тела запроса с невалидным ID", () -> {
            request = getAddNewPetModel(NOT_VALID_PET_ID);
        });

        step("Выполнение запроса POST /pet", () -> {
            responseWrapper = steps.createNewPetToStore(request);
        });

        step("Выполнение запроса GET /pet", () -> {
            responseWrapper = steps.getPetById(NOT_VALID_PET_ID);
        });

        step("Создание тела запроса с невалидным ID", () -> {
            request = getAddNewPetModel(NOT_VALID_PET_ID);
        });

        step("Выполнение запроса PUT /pet", () -> {
            responseWrapper = steps.updateAnExistingPet(request);
        });

        step("Проверка результата", () -> {
            int statusCode = responseWrapper.getStatusCode();
            ErrorResponse error = responseWrapper.as(ErrorResponse.class);

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_ERROR_500);
                        softAssertions
                                .assertThat(error)
                                .withFailMessage("Error body doesn't match")
                                .isEqualTo(getUnknownErrorResponse());
                    }
            );
        });
    }
}
