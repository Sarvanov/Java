package config;

import org.aeonbits.owner.Config;

/**
 * Интерфейс с конфигурацией проекта для тестов Авито страницы
 */
@Config.Sources({"classpath:avito_tests_config.properties"})
public interface AvitoTestsConfig extends BaseConfig {

    /**
     * Метод возвращает параметр linkAttribute из avito_tests_config.properties
     * @return параметр атрибута ссылки
     */
    String linkAttribute();

    /**
     * Метод возвращает параметр inputSearchGood из avito_tests_config.properties
     * @return параметр поиска товара
     */
    String inputSearchGood();

    /**
     * Метод возвращает параметр inputSearchCity из avito_tests_config.properties
     * @return параметр поиска города
     */
    String inputSearchCity();
}