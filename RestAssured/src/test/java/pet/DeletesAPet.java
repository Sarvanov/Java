package pet;

import base.BaseTest;
import dto.DeletesAPetModel;
import dto.PetModel;
import dto.response.ErrorResponse;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static utils.TestDataHelper.*;
import static utils.TestObjectBuilder.getAddNewPetModel;

/**
 * ����-���� ������ DELETE /pet/deletePet
 */
@Epic("Pet ����������")
@Feature("Deletes a pet")
public class DeletesAPet extends BaseTest {

    @Test
    @DisplayName("Deletes a pet. Positive case")
    @Story("�������� �������. ���������� ��������")
    public void testDeletesAPetPositive() {
        step("�������� ���� ������� � �������� ID", () -> {
            request = getAddNewPetModel(VALID_PET_ID);
        });

        step("���������� ������� POST /pet", () -> {
            responseWrapper = steps.createNewPetToStore(request);
        });

        step("���������� ������� GET /pet", () -> {
            responseWrapper = steps.getPetById(request.getId());
        });

        step("���������� ������� DELETE /pet", () -> {
            responseWrapper = steps.deletesAPetById(VALID_PET_ID);
        });

        step("�������� ����������", () -> {
            int statusCode = responseWrapper.getStatusCode();
            DeletesAPetModel response = responseWrapper.as(DeletesAPetModel.class);

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_OK);
                        softAssertions
                                .assertThat(response)
                                .withFailMessage("Response body doesn't match")
                                .isNotEqualTo(request);
                    }
            );
        });
    }

    @Test
    @DisplayName("Deletes a pet. Negative case")
    @Story("�������� �������. ���������� ��������")
    public void testDeletesAPetNegative() {
        step("�������� ���� ������� � ���������� ID", () -> {
            request = getAddNewPetModel(NOT_VALID_PET_ID);
        });

        step("���������� ������� POST /pet", () -> {
            responseWrapper = steps.createNewPetToStore(request);
        });

        step("���������� ������� GET /pet", () -> {
            responseWrapper = steps.getPetById(NOT_VALID_PET_ID);
        });

        step("���������� ������� DELETE /pet", () -> {
            responseWrapper = steps.deletesAPetById(NOT_VALID_PET_ID);
        });

        step("�������� ����������", () -> {
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