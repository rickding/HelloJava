package com.hello.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "server")
public class ServerConfig {
    private String domain;
    private long port;
    private boolean skipInit;
    private boolean testing;

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setPort(long port) {
        this.port = port;
    }

    public String getServerUrl() {
        String strPort = port > 0 && port != 80 ? String.format(":%d", port) : "";
        return String.format("http://%s%s", domain, strPort);
    }

    public boolean isSkipInit() {
        return skipInit;
    }

    public void setSkipInit(boolean skipInit) {
        this.skipInit = skipInit;
    }

    public boolean isTesting() {
        return testing;
    }

    public void setTesting(boolean testing) {
        this.testing = testing;
    }
}
