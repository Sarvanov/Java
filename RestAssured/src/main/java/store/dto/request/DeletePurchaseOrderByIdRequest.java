package store.dto.request;

import lombok.Builder;
import lombok.Data;

/**
 * ����� ��� ������� �� �������� purchase order
 */
@Data
@Builder(buildMethodName = "please", setterPrefix = "with")
public class DeletePurchaseOrderByIdRequest {

    @Builder.Default
    private final int id = 1;
}