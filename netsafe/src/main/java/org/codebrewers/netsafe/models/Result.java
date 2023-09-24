package org.codebrewers.netsafe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
    private UrlAnalysisResponse urlAnalysisResponse;
    private Decision decision;

    public UrlAnalysisResponse getUrlAnalysisResponse() {
        return urlAnalysisResponse;
    }

    public void setUrlAnalysisResponse(UrlAnalysisResponse urlAnalysisResponse) {
        this.urlAnalysisResponse = urlAnalysisResponse;
    }

    public Decision getDecision() {
        return decision;
    }

    public void setDecision(Decision decision) {
        this.decision = decision;
    }
}
