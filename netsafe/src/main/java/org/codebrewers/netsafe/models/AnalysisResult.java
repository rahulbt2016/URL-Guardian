package org.codebrewers.netsafe.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnalysisResult {
    @JsonProperty
    private String category;
    @JsonProperty
    private String result;

    @JsonProperty
    private String method;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getEngine_name() {
        return engine_name;
    }

    public void setEngine_name(String engine_name) {
        this.engine_name = engine_name;
    }

    @JsonProperty
    private String engine_name;
    // getters and setters
}