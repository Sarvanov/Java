package store.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * �������� ������ ��� ����������� �����
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreNotFoundResponse {

    private int code;
    private String type;
    private String message;
}