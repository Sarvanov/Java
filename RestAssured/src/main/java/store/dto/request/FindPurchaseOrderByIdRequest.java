package store.dto.request;

import lombok.Builder;
import lombok.Data;

/**
 * Класс для запроса нахождения purchase order по id
 */
@Data
@Builder(buildMethodName = "please", setterPrefix = "with")
public class FindPurchaseOrderByIdRequest {

    @Builder.Default
    private final int id = 1;
}
