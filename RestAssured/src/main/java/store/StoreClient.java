package store;

import helper.EndPoints;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;
import store.dto.request.PlaceAnOrderForAPetRequest;

import static io.restassured.RestAssured.given;

/**
 * Создание класса StoreClient
 */
@RequiredArgsConstructor
public class StoreClient {

    private final RequestSpecification requestSpecification;

    @Step("Place an order for a pet")
    public ValidatableResponse placeAnOrder(final PlaceAnOrderForAPetRequest bodyForPlaceAnOrder){
        return given()
                .spec(requestSpecification)
                .body(bodyForPlaceAnOrder)
                .when()
                .post(EndPoints.CONTEXT_PATH)
                .then();
    }
    @Step("Find purchase order by ID")
    public ValidatableResponse findPurchaseOrder(final int id){
        return given()
                .spec(requestSpecification)
                .when()
                .get(EndPoints.CONTEXT_PATH + "/" + id)
                .then();
    }
    @Step("Delete purchase order by ID")
    public ValidatableResponse deletePurchaseOrder(final int id){
        return given()
                .spec(requestSpecification)
                .when()
                .delete(EndPoints.CONTEXT_PATH + "/" + id)
                .then();
    }
}