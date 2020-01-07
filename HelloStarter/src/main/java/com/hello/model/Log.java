package com.hello.model;

import lombok.Data;

@Data
public class Log {
    private String summary;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
