package store;

import config.BaseConfig;
import helper.BodyGenerator;
import helper.Helper;
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

@Epic("Place an order for a pet")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlaceAnOrderForAPet {

    private StoreClient storeClient;
    private StoreModelResponse storeModelResponse;
    private BaseConfig config;

    @BeforeAll
    void setUp(){
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
    @DisplayName("Place an order for a pet")
    public void testPlaceAnOrderForAPet(){
        PlaceAnOrderForAPetRequest placeAnOrderForAPet = BodyGenerator.placeAnOrderForAPet()
                .withId(Integer.parseInt(Helper.getRandomId()))
                .please();

        storeModelResponse = storeClient.placeAnOrder(placeAnOrderForAPet)
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(StoreModelResponse.class);
    }

    @Test
    @Owner(value = "Aleksey Sarvanov")
    @DisplayName("Place an order for a pet. Negative test")
    public void testPlaceAnOrderForAPetNegative(){
        PlaceAnOrderForAPetRequest placeAnOrderForAPet = BodyGenerator.placeAnOrderForAPet()
                .withId(159138598)
                .please();

        storeModelResponse = storeClient.placeAnOrder(placeAnOrderForAPet)
                .assertThat()
                .statusCode(HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE)
                .extract().as(StoreModelResponse.class);
    }
}