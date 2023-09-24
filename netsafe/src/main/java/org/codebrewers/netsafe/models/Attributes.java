package org.codebrewers.netsafe.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Attributes {

    @JsonProperty
    private Votes total_votes;

    @JsonProperty
    private Long last_modification_date;
    @JsonProperty
    private int times_submitted;
    @JsonProperty
    private List<String> threat_names;
    @JsonProperty
    private List<String> redirection_chain;

    @JsonProperty
    private Map<String, AnalysisResult> last_analysis_results;

    @JsonProperty
    private Long last_submission_date;
    @JsonProperty
    private int last_http_response_content_length;
    @JsonProperty
    private Map<String, String> last_http_response_headers;
    @JsonProperty
    private int reputation;
    @JsonProperty
    private List<String> tags;
    @JsonProperty
    private Long last_analysis_date;
    @JsonProperty
    private Long first_submission_date;
    @JsonProperty
    private Map<String, String> categories;
    @JsonProperty
    private String last_http_response_content_sha256;
    @JsonProperty
    private int last_http_response_code;
    @JsonProperty
    private String last_final_url;
    @JsonProperty
    private Trackers trackers;
    @JsonProperty
    private String url;
    @JsonProperty
    private String title;
    @JsonProperty
    private String tld;
    @JsonProperty
    private LastAnalysisStats last_analysis_stats;

    @JsonProperty
    private List<String> outgoing_links;

    @JsonProperty("html_meta")
    private HtmlMeta htmlMeta;

    public Votes getTotal_votes() {
        return total_votes;
    }

    public void setTotal_votes(Votes total_votes) {
        this.total_votes = total_votes;
    }

    public Long getLast_modification_date() {
        return last_modification_date;
    }

    public void setLast_modification_date(Long last_modification_date) {
        this.last_modification_date = last_modification_date;
    }

    public int getTimes_submitted() {
        return times_submitted;
    }

    public void setTimes_submitted(int times_submitted) {
        this.times_submitted = times_submitted;
    }

    public List<String> getThreat_names() {
        return threat_names;
    }

    public void setThreat_names(List<String> threat_names) {
        this.threat_names = threat_names;
    }

    public List<String> getRedirection_chain() {
        return redirection_chain;
    }

    public void setRedirection_chain(List<String> redirection_chain) {
        this.redirection_chain = redirection_chain;
    }

    public Map<String, AnalysisResult> getLast_analysis_results() {
        return last_analysis_results;
    }

    public void setLast_analysis_results(Map<String, AnalysisResult> last_analysis_results) {
        this.last_analysis_results = last_analysis_results;
    }

    public Long getLast_submission_date() {
        return last_submission_date;
    }

    public void setLast_submission_date(Long last_submission_date) {
        this.last_submission_date = last_submission_date;
    }

    public int getLast_http_response_content_length() {
        return last_http_response_content_length;
    }

    public void setLast_http_response_content_length(int last_http_response_content_length) {
        this.last_http_response_content_length = last_http_response_content_length;
    }

    public Map<String, String> getLast_http_response_headers() {
        return last_http_response_headers;
    }

    public void setLast_http_response_headers(Map<String, String> last_http_response_headers) {
        this.last_http_response_headers = last_http_response_headers;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Long getLast_analysis_date() {
        return last_analysis_date;
    }

    public void setLast_analysis_date(Long last_analysis_date) {
        this.last_analysis_date = last_analysis_date;
    }

    public Long getFirst_submission_date() {
        return first_submission_date;
    }

    public void setFirst_submission_date(Long first_submission_date) {
        this.first_submission_date = first_submission_date;
    }

    public Map<String, String> getCategories() {
        return categories;
    }

    public void setCategories(Map<String, String> categories) {
        this.categories = categories;
    }

    public String getLast_http_response_content_sha256() {
        return last_http_response_content_sha256;
    }

    public void setLast_http_response_content_sha256(String last_http_response_content_sha256) {
        this.last_http_response_content_sha256 = last_http_response_content_sha256;
    }

    public int getLast_http_response_code() {
        return last_http_response_code;
    }

    public void setLast_http_response_code(int last_http_response_code) {
        this.last_http_response_code = last_http_response_code;
    }

    public String getLast_final_url() {
        return last_final_url;
    }

    public void setLast_final_url(String last_final_url) {
        this.last_final_url = last_final_url;
    }

    public Trackers getTrackers() {
        return trackers;
    }

    public void setTrackers(Trackers trackers) {
        this.trackers = trackers;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTld() {
        return tld;
    }

    public void setTld(String tld) {
        this.tld = tld;
    }

    public LastAnalysisStats getLast_analysis_stats() {
        return last_analysis_stats;
    }

    public void setLast_analysis_stats(LastAnalysisStats last_analysis_stats) {
        this.last_analysis_stats = last_analysis_stats;
    }

    public List<String> getOutgoing_links() {
        return outgoing_links;
    }

    public void setOutgoing_links(List<String> outgoing_links) {
        this.outgoing_links = outgoing_links;
    }

    public HtmlMeta getHtmlMeta() {
        return htmlMeta;
    }

    public void setHtmlMeta(HtmlMeta htmlMeta) {
        this.htmlMeta = htmlMeta;
    }
}
