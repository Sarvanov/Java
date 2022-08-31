package dto;

import lombok.Builder;
import lombok.Data;

/**
 * �������� ������ DeletesAPetModel
 */
@Data
@Builder
public class DeletesAPetModel {

    private final int code;
    private final String type;
    private final String message;
}
