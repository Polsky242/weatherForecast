package myProject.weatherForecAst.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.*;

@Service
public class ClientDateService {
    private final RestTemplate restTemplate;

    @Autowired
    public ClientDateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public int clientDate(String city) {
        try {
            String apiUrl = "http://localhost:8080/API/cities";
            ResponseEntity<JsonNode> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, JsonNode.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                JsonNode root = response.getBody();
                if (root != null) {
                    for (JsonNode node : root) {
                        if (node.has("name") &&
                                node.get("name").asText().equals(city)) {

                            String date = node.path("timezone").asText();
                            ZoneId zoneId = ZoneId.of(date);
                            return ZonedDateTime.now(zoneId).getDayOfWeek().getValue();
                        }
                    }
                }
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
}
