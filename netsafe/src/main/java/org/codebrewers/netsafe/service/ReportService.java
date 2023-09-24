package org.codebrewers.netsafe.service;

import org.codebrewers.netsafe.models.IntakeAnalysisReply;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.codebrewers.netsafe.utils.IntakeUtil.getProcessingId;

@Component
public class ReportService {
    final String baseUrl = "https://www.virustotal.com/api/v3/urls/{myProcessingId}";
    final String apiKey = "417b5cedc329a1f8fd7469f46d9845bde7ae2a0cf57843685dcf46a3eba80edc";
    public String fetchReport(IntakeAnalysisReply intakeAnalysisReply){
        var processingId = getProcessingId(intakeAnalysisReply);
        var restTemplate = new RestTemplate();

        // Create headers
        var headers = new HttpHeaders();
        headers.set("x-apikey", apiKey);

        // Set http entity (headers and body, in this case, only headers)
        // Set http entity (headers and body, in this case, only headers)
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Make the GET request
        ResponseEntity<String> response = restTemplate.exchange(
                URI.create(baseUrl.replace("{myProcessingId}", processingId)),
                HttpMethod.GET,
                entity,
                String.class);

        // Print the response
        return response.getBody();
    }
}
