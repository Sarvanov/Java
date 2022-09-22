import database.SqlConnector;
import database.steps.SqlSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;

/**
 * ������� �������� �����
 */
public class BaseTest {

    /**
     * ���������� � ������ SQL
     */
    protected SqlSteps steps;

    /**
     * ��������� ������ SQL ����������
     */
    private final SqlConnector connector = new SqlConnector();

    /**
     * ���������� � ������������
     */
    protected Connection connection;

    @BeforeEach
    public void setUp() {
        // �������� ����������� � ��
        connection = connector.openConnection();

        // �������� ������� SqlSteps
        steps = new SqlSteps(connection);
    }

    @AfterEach
    public void tearDown() {
        // �������� ����������� � ��
        connector.closeConnection(connection);
    }
}