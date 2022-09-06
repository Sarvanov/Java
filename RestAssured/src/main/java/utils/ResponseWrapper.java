package utils;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * ��������������� �����, �������� ��� ������ � ��������
 */
@AllArgsConstructor
public class ResponseWrapper {

    /**
     * ����� � Rest Assured
     */
    private final Response response;

    /**
     * ����� �������������� ���� ������ � �������
     * @param Clazz ����� �������
     * @return ������
     * @param <T> ��� ������ �������
     */
    public <T> T as(Class<T> Clazz){
        return response.as(Clazz);
    }

    /**
     * ����� �������������� ���� ������ � ������ ��������
     * @param Clazz ������ ������� �������
     * @return ������ ��������
     * @param <T> ��� ������ �������
     */
    public <T> List<T> asList(Class<T[]> Clazz){
        return List.of(response.as(Clazz));
    }

    /**
     * ����� ��������� ������ ���� ������
     * @return ������ ���
     */
    public int getStatusCode(){
        return response.getStatusCode();
    }
}