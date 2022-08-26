package helper;

import lombok.experimental.UtilityClass;
import store.dto.request.DeletePurchaseOrderByIdRequest;
import store.dto.request.FindPurchaseOrderByIdRequest;
import store.dto.request.PlaceAnOrderForAPetRequest;

@UtilityClass
public class BodyGenerator {

    public static PlaceAnOrderForAPetRequest.PlaceAnOrderForAPetRequestBuilder placeAnOrderForAPet() {
        return PlaceAnOrderForAPetRequest.builder();
    }

    public static FindPurchaseOrderByIdRequest.FindPurchaseOrderByIdRequestBuilder findPurchaseOrderById(){
        return FindPurchaseOrderByIdRequest.builder();
    }


    public static DeletePurchaseOrderByIdRequest.DeletePurchaseOrderByIdRequestBuilder deletePurchaseOrderById(){
        return DeletePurchaseOrderByIdRequest.builder();
    }
}