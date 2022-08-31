package store.dto.request;

import lombok.Builder;
import lombok.Data;

/**
 * ����� ��� ������� ���������� purchase order �� id
 */
@Data
@Builder(buildMethodName = "please", setterPrefix = "with")
public class FindPurchaseOrderByIdRequest {

    @Builder.Default
    private final int id = 1;
}
