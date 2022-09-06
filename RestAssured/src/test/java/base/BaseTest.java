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
 * ������� �������� ����� � ������ �����������
 */
public class BaseTest {

    /**
     * ��������� ���������� � �������������
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * ��������� ������ � REST ������
     */
    protected final Steps steps = new Steps(getRequestSpecification());

    /**
     * ��������� ������ � ����� �������
     */
    protected PetModel request;

    /**
     * ��������� ������ � ��������� ������
     */
    protected ResponseWrapper responseWrapper;

    /**
     * ����� ��� ��������� ������������ Rest Assured
     * <p>
     * baseUrl - ������� URL
     * contentType - �������� � header �� ��������� JSON
     * accept - �������� � header �� ��������� JSON
     * filter - ������� ������ ��� allure
     * log - ����������� ���� �������
     *
     * @return ������������
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