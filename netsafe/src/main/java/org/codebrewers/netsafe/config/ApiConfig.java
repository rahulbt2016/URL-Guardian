package org.codebrewers.netsafe.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class ApiConfig {
    @Value("${api.config.apikey}")
    private String XAPIKEY;

    public String getApikey() {
        return XAPIKEY;
    }

}
