package utils;

import dto.response.ErrorResponse;

/**
 * Вспомогательный класс для формирования ожидаемых результатов
 */
public class ExpectedObjectBuilder {

    /**
     * Код неизвестной ошибки
     */
    public static final int UNKNOWN_CODE = 500;

    /**
     * Тип неизвестной ошибки
     */
    private static final String UNKNOWN_TYPE = "unknown";

    /**
     * Сообщение неизвестной ошибки
     */
    private static final String UNKNOWN_MESSAGE = "something bad happened";

    /**
     * Метод формирования ожидаемого результата неизвестной ошибки
     * @return тело ошибки
     */
    public static ErrorResponse getUnknownErrorResponse(){
        return ErrorResponse.builder()
                .code(UNKNOWN_CODE)
                .type(UNKNOWN_TYPE)
                .message(UNKNOWN_MESSAGE)
                .build();
    }


}