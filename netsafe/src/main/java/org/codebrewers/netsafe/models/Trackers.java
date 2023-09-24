package org.codebrewers.netsafe.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Trackers {
    @JsonProperty("Google Analytics")
    public List<TrackerEngine> google_analytics;
    @JsonProperty("Google Tag Manager")
    public List<TrackerEngine> google_tag_manager;
    @JsonProperty("Google AdSense")
    public List<TrackerEngine> google_ad_sense;
}