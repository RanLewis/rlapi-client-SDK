package com.ranlewis.rlapi;

import com.ranlewis.rlapi.client.RLAPIClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * RLAPIClientConfig
 *
 * @author Ran Lewis
 * @version 1.0
 * @since 2024/11/15
 */
@Configuration
@ConfigurationProperties(prefix = "rlapi.client")
@Data
@ComponentScan
public class RLAPIClientConfig {

    private String accessKey;
    private String secretKey;

    @Bean
    public RLAPIClient rlAPIClient(){
        return new RLAPIClient(accessKey,secretKey);
    }
}
