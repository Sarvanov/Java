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
 * ����-���� ������ GET /pet/getPetById
 */
@Epic("Pet ����������")
@Feature("Find pet by ID")
public class FindPetById extends BaseTest {

    @Test
    @DisplayName("Find pet by ID. Positive case")
    @Story("����� ������� �� ID. ���������� ��������")
    public void testFindPetByIdPositive() {
        step("�������� ���� ������� � �������� ID", () -> {
            request = getAddNewPetModel(VALID_PET_ID);
        });

        step("���������� ������� POST /pet", () -> {
            responseWrapper = steps.createNewPetToStore(request);
        });

        step("���������� ������� GET /pet", () -> {
            responseWrapper = steps.getPetById(VALID_PET_ID);
        });

        step("�������� ����������", () -> {
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
    @Story("����� ������� �� ID. ���������� ��������")
    public void testFindPetByIdNegative() {
        step("�������� ���� ������� � ���������� ID", () -> {
            request = getAddNewPetModel(NOT_VALID_PET_ID);
        });

        step("���������� ������� POST /pet", () -> {
            responseWrapper = steps.createNewPetToStore(request);
        });

        step("���������� ������� GET /pet", () -> {
            responseWrapper = steps.getPetById(NOT_VALID_PET_ID);
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