package store;

import config.BaseConfig;
import helper.BodyGenerator;
import helper.Helper;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import store.dto.request.PlaceAnOrderForAPetRequest;
import store.dto.response.DeleteModelResponse;
import store.dto.response.StoreModelResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@Epic("Delete purchase order by id")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DeletePurchaseOrderById {

    private int id;
    private StoreClient storeClient;
    private StoreModelResponse storeModelResponse;
    private BaseConfig config;
    private DeleteModelResponse deleteModelResponse;

    @BeforeAll
    void setUp() {
        config = ConfigFactory.create(BaseConfig.class);

        RequestSpecification placeAnOrder = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .setBaseUri(config.baseUrl())
                .build();

        storeClient = new StoreClient(placeAnOrder);
    }

    @Test
    @Owner(value = "Aleksey Sarvanov")
    @DisplayName("Delete an order for a pet")
    public void testDeleteAnOrderForAPet() {
        Allure.step("Шаг 1. Добавить purchase order в store", () -> {
            PlaceAnOrderForAPetRequest placeAnOrderForAPet = BodyGenerator.placeAnOrderForAPet()
                    .withId(Integer.parseInt(Helper.getRandomId()))
                    .withPetId(100)
                    .withQuantity(1)
                    .withStatus("placed")
                    .withComplete(true)
                    .please();

            storeModelResponse = storeClient.placeAnOrder(placeAnOrderForAPet)
                    .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(StoreModelResponse.class);

            id = storeModelResponse.getId();

            assertAll(
                    () -> assertThat(storeModelResponse.getId()).withFailMessage("Id doesn't match").isEqualTo(id),
                    () -> assertThat(storeModelResponse.getPetId()).withFailMessage("PetId doesn't match").isEqualTo(100),
                    () -> assertThat(storeModelResponse.getQuantity()).withFailMessage("Quantity doesn't match").isEqualTo(1),
                    () -> assertThat(storeModelResponse.getStatus()).withFailMessage("Status doesn't match").isEqualTo("placed"),
                    () -> assertThat(storeModelResponse.isComplete()).withFailMessage("Complete doesn't match").isEqualTo(true)
            );
        });

        Allure.step("Шаг 2. Удалить purchase order из store", () -> {
            deleteModelResponse = storeClient.deletePurchaseOrder(id)
                    .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(DeleteModelResponse.class);

            assertAll(
                    () -> assertThat(deleteModelResponse.getCode()).withFailMessage("Code doesn't match").isEqualTo(200),
                    () -> assertThat(deleteModelResponse.getType()).withFailMessage("Type doesn't match").isEqualTo("unknown"),
                    () -> assertThat(deleteModelResponse.getMessage()).withFailMessage("Message doesn't match").isEqualTo(Integer.toString(id))
            );
        });

        Allure.step("Шаг 3. Удалить purchase order из store ещё раз", () -> {
            deleteModelResponse = storeClient.deletePurchaseOrder(id)
                    .assertThat()
                    .statusCode(HttpStatus.SC_NOT_FOUND)
                    .extract().as(DeleteModelResponse.class);

            assertAll(
                    () -> assertThat(deleteModelResponse.getCode()).withFailMessage("Code doesn't match").isEqualTo(404),
                    () -> assertThat(deleteModelResponse.getType()).withFailMessage("Type doesn't match").isEqualTo("unknown"),
                    () -> assertThat(deleteModelResponse.getMessage()).withFailMessage("Message doesn't match").isEqualTo("Order Not Found")
            );
        });
    }
}