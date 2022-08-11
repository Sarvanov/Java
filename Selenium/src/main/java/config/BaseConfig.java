package config;

import org.aeonbits.owner.Config;

/**
 * ��������� � �������� ������������� �������
 */
@Config.Sources({"classpath:config.properties"})
public interface BaseConfig extends Config {

    /**
     * ����� ���������� �������� url �� config.properties
     * @return �������� url ������
     */
    String url();

    /**
     * ����� ���������� �������� driverPath �� config.properties
     * @return �������� ���� � chromedriver
     */
    String driverPath();

    /**
     * ����� ���������� �������� driverProperty �� config.properties
     * @return �������� ��������� driver
     */
    String driverProperty();
}
