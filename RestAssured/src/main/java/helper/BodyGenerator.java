package helper;

import lombok.experimental.UtilityClass;
import store.dto.request.PlaceAnOrderForAPetRequest;

/**
 * �������� BodyGenerator
 */
@UtilityClass
public class BodyGenerator {

    public static PlaceAnOrderForAPetRequest.PlaceAnOrderForAPetRequestBuilder placeAnOrderForAPet() {
        return PlaceAnOrderForAPetRequest.builder();
    }
}