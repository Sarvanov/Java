package config;

import org.aeonbits.owner.Config;

/**
 * ��������� � ����������� �������� ������������
 */
@Config.Sources({"classpath:config.properties"})
public interface BaseConfig extends Config {

    /**
     * ����� �������� �����������
     *
     * @return ����� ��������
     */
    String driverDb();

    /**
     * ����� ���� ������
     *
     * @return ����� ���� ������
     */
    String urlDb();

    /**
     * ��� ������������ ���� ������
     *
     * @return ������������
     */
    String userDb();

    /**
     * ������ ���� ������
     *
     * @return ������
     */
    String passwordDb();
}