package org.codebrewers.netsafe.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrackerEngine {
    @JsonProperty
    private String url;
    @JsonProperty
    private Long timestamp;
    @JsonProperty
    private String id;
    // getters and setters
}
