package com.sefersezer.stringsmilarity.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.yml")
@ConfigurationProperties(prefix = "ds")
@Data
public class Config {

    @Value("textDataSource")
    private String textDataSource;
}
