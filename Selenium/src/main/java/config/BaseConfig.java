package config;

import org.aeonbits.owner.Config;

/**
 * Интерфейс с основной конфигурацией проекта
 */
@Config.Sources({"classpath:config.properties"})
public interface BaseConfig extends Config {

    /**
     * Метод возвращает параметр url из config.properties
     * @return параметр url ссылки
     */
    String url();

    /**
     * Метод возвращает параметр driverPath из config.properties
     * @return параметр путь к chromedriver
     */
    String driverPath();

    /**
     * Метод возвращает параметр driverProperty из config.properties
     * @return параметр настройка driver
     */
    String driverProperty();
}
