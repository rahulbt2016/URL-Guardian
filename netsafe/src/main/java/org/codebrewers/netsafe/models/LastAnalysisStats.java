package org.codebrewers.netsafe.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LastAnalysisStats {
    @JsonProperty
    private int harmless;
    @JsonProperty
    private int malicious;
    @JsonProperty
    private int suspicious;
    @JsonProperty
    private int undetected;
    @JsonProperty
    private int timeout;
    // getters and setters
}