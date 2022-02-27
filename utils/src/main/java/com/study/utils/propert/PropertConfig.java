package com.study.utils.propert;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@PropertySource(value = "classpath:test.yml", factory = YamlPropertySourceFactory.class)
//@PropertySources({@PropertySource("classpath:test.yml"),
//@PropertySource("")})
@ConfigurationProperties(prefix = "test")
public class PropertConfig {

    private int id;
    private String name;
    private List<String> books;
    private Map<String, Integer> goods;

}
