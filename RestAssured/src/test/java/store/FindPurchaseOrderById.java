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
import store.dto.response.StoreModelResponse;
import store.dto.response.StoreNotFoundResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@Epic("Find purchase order by ID")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FindPurchaseOrderById {

    private StoreClient storeClient;
    private StoreModelResponse storeModelResponse;
    private StoreNotFoundResponse storeNotFoundResponse;
    private int id;
    private BaseConfig config;

    @BeforeAll
    void setUp() {
        config = ConfigFactory.create(BaseConfig.class);

        RequestSpecification findPurchase = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .setBaseUri(config.baseUrl())
                .build();

        storeClient = new StoreClient(findPurchase);
    }

    @Test
    @Owner(value = "Aleksey Sarvanov")
    @DisplayName("Find purchase order by ID")
    public void testFindPurchaseOrderById() {
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

        Allure.step("Шаг 2. Найти добавленный purchase order по ID", () -> {
            storeModelResponse = storeClient.findPurchaseOrder(id)
                    .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(StoreModelResponse.class);

            assertAll(
                    () -> assertThat(storeModelResponse.getId()).withFailMessage("Id doesn't match").isEqualTo(id),
                    () -> assertThat(storeModelResponse.getPetId()).withFailMessage("PetId doesn't match").isEqualTo(100),
                    () -> assertThat(storeModelResponse.getQuantity()).withFailMessage("Quantity doesn't match").isEqualTo(1),
                    () -> assertThat(storeModelResponse.getStatus()).withFailMessage("Status doesn't match").isEqualTo("placed"),
                    () -> assertThat(storeModelResponse.isComplete()).withFailMessage("Complete doesn't match").isEqualTo(true)
            );
        });

        Allure.step("Шаг 3. Найти добавленный purchase order по ID. Negative test", () -> {
            storeNotFoundResponse = storeClient.findPurchaseOrder(1)
                    .assertThat()
                    .statusCode(HttpStatus.SC_NOT_FOUND)
                    .extract().as(StoreNotFoundResponse.class);

            assertAll(
                    () -> assertThat(storeNotFoundResponse.getCode()).withFailMessage("Code doesn't match").isEqualTo(1),
                    () -> assertThat(storeNotFoundResponse.getType()).withFailMessage("Type doesn't match").isEqualTo("error"),
                    () -> assertThat(storeNotFoundResponse.getMessage()).withFailMessage("Message doesn't match").isEqualTo("Order not found")
            );
        });
    }
}