package config;

import org.aeonbits.owner.Config;

/**
 * ��������� � ������������� ������� ��� ������ ����� ��������
 */
@Config.Sources({"classpath:avito_tests_config.properties"})
public interface AvitoTestsConfig extends BaseConfig {

    /**
     * ����� ���������� �������� linkAttribute �� avito_tests_config.properties
     * @return �������� �������� ������
     */
    String linkAttribute();

    /**
     * ����� ���������� �������� inputSearchGood �� avito_tests_config.properties
     * @return �������� ������ ������
     */
    String inputSearchGood();

    /**
     * ����� ���������� �������� inputSearchCity �� avito_tests_config.properties
     * @return �������� ������ ������
     */
    String inputSearchCity();
}