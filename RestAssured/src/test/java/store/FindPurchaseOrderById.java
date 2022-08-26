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
import store.dto.request.FindPurchaseOrderByIdRequest;
import store.dto.response.DeleteModelResponse;
import store.dto.response.StoreModelResponse;

@Epic("Find purchase order by ID")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FindPurchaseOrderById {

    private StoreClient storeClient;
    private StoreModelResponse storeModelResponse;

    private DeleteModelResponse deleteModelResponse;
    private BaseConfig config;

    @BeforeAll
    void setUp(){
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
    public void testFindPurchaseOrderById(){
        FindPurchaseOrderByIdRequest findPurchaseOrder = BodyGenerator.findPurchaseOrderById()
//                .withId(Integer.parseInt(Helper.getRandomId()))
                .withId(1)
                .please();

//        storeModelResponse = storeClient.findPurchaseOrder(findPurchaseOrder)
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK)
//                .extract().as(StoreModelResponse.class);

        storeClient.findPurchaseOrder(findPurchaseOrder)
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(StoreModelResponse.class);
    }

    @Test
    @Owner(value = "Aleksey Sarvanov")
    @DisplayName("Find purchase order by ID. Negative test")
    public void testFindPurchaseOrderByIdNegative(){
        FindPurchaseOrderByIdRequest findPurchaseOrder = BodyGenerator.findPurchaseOrderById()
//                .withId(Integer.parseInt(Helper.getRandomId()))
                .withId(777777777)
//                .withId(1)
                .please();

        deleteModelResponse = storeClient.findPurchaseOrder(findPurchaseOrder)
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .extract().as(DeleteModelResponse.class);

    }
}
