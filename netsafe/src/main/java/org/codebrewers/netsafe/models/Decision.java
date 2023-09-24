package org.codebrewers.netsafe.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Decision implements Serializable {

    @JsonProperty
    private boolean canRedirect;
    @JsonProperty
    private int maliciousVotes;
    @JsonProperty
    private int suspiciousVotes;
    @JsonProperty
    private List<String> vendorNameMalicious;
    @JsonProperty
    private List<String> vendorNameSuspicious;
    @JsonProperty
    private List<String> trackers;

    @JsonProperty
    private UrlAnalysisResponse urlAnalysisResponse;

    public Decision(boolean canRedirect, int maliciousVotes, int suspiciousVotes, List<String> vendorNameMalicious, List<String> vendorNameSuspicious, List<String> trackers, UrlAnalysisResponse urlAnalysisResponse) {
        this.canRedirect = canRedirect;
        this.maliciousVotes = maliciousVotes;
        this.suspiciousVotes = suspiciousVotes;
        this.vendorNameMalicious = vendorNameMalicious;
        this.vendorNameSuspicious = vendorNameSuspicious;
        this.trackers = trackers;
        this.urlAnalysisResponse = urlAnalysisResponse;
    }
}
