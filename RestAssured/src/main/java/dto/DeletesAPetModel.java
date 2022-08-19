package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeletesAPetModel {

    private final int code;
    private final String type;
    private final String message;
}
