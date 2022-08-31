package store.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * �������� ������
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreModelResponse {

    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;
}