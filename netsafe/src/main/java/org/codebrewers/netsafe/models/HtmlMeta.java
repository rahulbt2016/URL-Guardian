package org.codebrewers.netsafe.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HtmlMeta {

    @JsonProperty
    private List<String> description;
    @JsonProperty
    private List<String> viewport;
    @JsonProperty
    private List<String> keywords;
    @JsonProperty
    private List<String> author;
    @JsonProperty("og:description")
    private List<String> ogDescription;
    @JsonProperty("og:title")
    private List<String> ogTitle;
    @JsonProperty("og:image")
    private List<String> imageUrl;
    @JsonProperty("facebook-domain-verification")
    private List<String> facebookDomainVerification;


}