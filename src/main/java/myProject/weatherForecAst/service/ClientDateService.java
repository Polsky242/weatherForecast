package myProject.weatherForecAst.service;

import com.fasterxml.jackson.databind.JsonNode;
import myProject.weatherForecAst.properties.AppProperties;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class ClientDateService {
    private final AppProperties appProperties;
    private final RestTemplate restTemplate;
    public ClientDateService(AppProperties appProperties, RestTemplate restTemplate) {
        this.appProperties = appProperties;
        this.restTemplate = restTemplate;
    }

    public int clientDate(String city) {
        try {
            String apiURL = appProperties.getApiURL().replace("YOUR_DEFAULT_CITY", city);
            ResponseEntity<JsonNode> response = restTemplate.exchange(apiURL, HttpMethod.GET, null, JsonNode.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                JsonNode root = response.getBody();
                assert root != null;
                int date = root.path("list").path(0).path("dt").asInt();
                Instant instant = Instant.ofEpochSecond(date);
                LocalDate dateF = instant.atZone(ZoneId.systemDefault()).toLocalDate();
                return dateF.getDayOfWeek().getValue();
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
