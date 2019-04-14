package com.wiesen.parking.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description
 * @auther wiesen
 * @create 2019-04-13 22:13
 */
@Component
@ConfigurationProperties(prefix = "parking") //接收application.yml中的parking下面的属性
@Data
public class ConfigProperties {
    List<String> ignoreUris;
}
