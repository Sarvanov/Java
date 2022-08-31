package store.dto.request;

import lombok.Builder;
import lombok.Data;

/**
 * Класс для запроса по добавлению purchase order в store
 */
@Data
@Builder(buildMethodName = "please", setterPrefix = "with")
public class PlaceAnOrderForAPetRequest {

    @Builder.Default
    private final int id = 1;

    @Builder.Default
    private final int petId = 0;

    @Builder.Default
    private final int quantity = 0;

    @Builder.Default
    private final String shipDate = "2022-08-23T13:15:41.158Z";

    @Builder.Default
    private final String status = "placed";

    @Builder.Default
    private final boolean complete = true;
}