package org.codebrewers.netsafe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.codebrewers.netsafe.config.ApiConfig;
import org.codebrewers.netsafe.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@EnableCaching
@ImportAutoConfiguration(classes = {
        CacheAutoConfiguration.class,
        RedisAutoConfiguration.class
})
@Cacheable(value = "urlAnalysis", key = "#intakeBody.intakeUrl")
public class IntakeService {

    public static final String BASE_URL = "https://www.virustotal.com/api/v3/urls";
    public static final String URL = "url";
    public static final String X_APIKEY = "x-apikey";
    @Autowired
    ApiConfig apiConfig;

    @Autowired
    ReportService reportService;

    @PostMapping("/scoreUrl")
    @Cacheable(value = "urlCache")
    public Decision scoreURL(@RequestBody IntakeBody intakeBody) throws JsonProcessingException {
        // Dynamically build the URL with query parameters
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_URL).queryParam(URL, intakeBody.getIntakeUrl());
        var restTemplate = new RestTemplate();

        // Set headers
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set(X_APIKEY, apiConfig.getApikey());

        // Create an HTTP entity with the headers
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        // Send POST request
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, String.class);

        // Use response id to fetch report form report service
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        var intakeAnalysisReply = objectMapper.readValue(response.getBody(), IntakeAnalysisReply.class);

        var urlAnalysisResponse = objectMapper.readValue(reportService.fetchReport(intakeAnalysisReply), UrlAnalysisResponse.class);

        var maliciousVotes = Optional.ofNullable(urlAnalysisResponse)
                .map(UrlAnalysisResponse::getDataResponse)
                .map(DataResponse::getAttributes)
                .map(Attributes::getTotal_votes)
                .map(Votes::getMalicious)
                .get();
        var suspiciousVotes = Optional.ofNullable(urlAnalysisResponse)
                .map(UrlAnalysisResponse::getDataResponse)
                .map(DataResponse::getAttributes)
                .map(Attributes::getTotal_votes)
                .map(Votes::getSuspicious)
                .get();

        var canRedirect = suspiciousVotes >= 2 || maliciousVotes >= 1?true:false;

        var vendorNames = Optional.ofNullable(urlAnalysisResponse)
                .map(UrlAnalysisResponse::getDataResponse)
                .map(DataResponse::getAttributes)
                .map(Attributes::getLast_analysis_results)
                .get();

        List<String> vendorNameMalicious = new ArrayList<>();
        List<String> vendorNameSuspicious = new ArrayList<>();
        vendorNames.forEach((key, value)->{
            if(value.getCategory().trim().equalsIgnoreCase("malicious")){
                vendorNameMalicious.add(value.getEngine_name());
            }
            else if (value.getCategory().trim().equalsIgnoreCase("suspicious")){
                vendorNameSuspicious.add(value.getEngine_name());
            }
        });


        var trackersList = new ArrayList<String>();
        Trackers trackers = Optional.ofNullable(urlAnalysisResponse)
                .map(UrlAnalysisResponse::getDataResponse)
                .map(DataResponse::getAttributes)
                .map(Attributes::getTrackers)
                .get();

        for(Field field : trackers.getClass().getDeclaredFields()){
            try {
                if(field.get(trackers)!=null){
                    trackersList.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        var decision = new Decision(canRedirect, maliciousVotes, suspiciousVotes, vendorNameMalicious, vendorNameSuspicious, trackersList, urlAnalysisResponse);

        return decision;

    }
}

