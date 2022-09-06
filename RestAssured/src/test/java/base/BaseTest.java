package base;

import config.BaseConfig;
import dto.PetModel;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import steps.Steps;
import utils.ResponseWrapper;

/**
 * Ѕазовый тестовый класс с общими настройками
 */
public class BaseTest {

    /**
     * Ёкземпл€р интерфейса с конфигурацией
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Ёкземпл€р класса с REST шагами
     */
    protected final Steps steps = new Steps(getRequestSpecification());

    /**
     * Ёкземпл€р класса с телом запроса
     */
    protected PetModel request;

    /**
     * Ёкземпл€р класса с оболочкой ответа
     */
    protected ResponseWrapper responseWrapper;

    /**
     * ћетод дл€ получени€ спецификации Rest Assured
     * <p>
     * baseUrl - базовый URL
     * contentType - параметр в header со значением JSON
     * accept - параметр в header со значением JSON
     * filter - создает фильтр дл€ allure
     * log - логирование всех деталей
     *
     * @return спецификаци€
     */
    private RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(config.baseUrl())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addFilter((new AllureRestAssured()))
                .log(LogDetail.ALL)
                .build();
    }
}