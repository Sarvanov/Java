package database;

import config.BaseConfig;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ����� ��� ����������� � ���� ������
 */
public class SqlConnector {

    /**
     * ���������� ������������
     */
    private static final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * ����� �������� ����������� � ���� ������
     *
     * @return ��������� �����������
     */
    @SneakyThrows
    public Connection openConnection(){
        Class.forName(config.driverDb());
        return DriverManager.getConnection(config.urlDb(), config.userDb(), config.passwordDb());
    }

    /**
     * ����� �������� ����������� � ���� �����
     *
     * @param connection ��������� �����������
     */
    @SneakyThrows
    public void closeConnection(Connection connection){
        connection.close();
    }
}