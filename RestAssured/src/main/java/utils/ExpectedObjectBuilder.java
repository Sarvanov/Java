package utils;

import dto.response.ErrorResponse;

/**
 * ��������������� ����� ��� ������������ ��������� �����������
 */
public class ExpectedObjectBuilder {

    /**
     * ��� ����������� ������
     */
    public static final int UNKNOWN_CODE = 500;

    /**
     * ��� ����������� ������
     */
    private static final String UNKNOWN_TYPE = "unknown";

    /**
     * ��������� ����������� ������
     */
    private static final String UNKNOWN_MESSAGE = "something bad happened";

    /**
     * ����� ������������ ���������� ���������� ����������� ������
     * @return ���� ������
     */
    public static ErrorResponse getUnknownErrorResponse(){
        return ErrorResponse.builder()
                .code(UNKNOWN_CODE)
                .type(UNKNOWN_TYPE)
                .message(UNKNOWN_MESSAGE)
                .build();
    }


}