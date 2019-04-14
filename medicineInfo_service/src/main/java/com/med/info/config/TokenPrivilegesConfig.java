package com.med.info.config;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Configuration
@Component
@ConfigurationProperties(prefix = "web.token.privilege")
public class TokenPrivilegesConfig {

    private HashMap uriPrivileges;
    private List<String> noTokenUrls;

    public HashMap getUriPrivileges() {
        return uriPrivileges;
    }

    public void setUriPrivileges(HashMap uriPrivileges) {
        this.uriPrivileges = uriPrivileges;
    }

    public List<String> getNoTokenUrls() {
        return noTokenUrls;
    }

    public void setNoTokenUrls(List<String> noTokenUrls) {
        this.noTokenUrls = noTokenUrls;
    }
}
