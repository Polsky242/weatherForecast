package myProject.weatherForecAst.service;

import com.fasterxml.jackson.databind.JsonNode;
import myProject.weatherForecAst.models.WeatherModel;
import myProject.weatherForecAst.properties.AppProperties;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class ApiDataService {
    private final RestTemplate restTemplate;
    private final AppProperties appProperties;


    public ApiDataService(RestTemplate restTemplate, AppProperties appProperties) {
        this.restTemplate = restTemplate;
        this.appProperties = appProperties;
    }

    public ArrayList<WeatherModel> getDataFromApi(String city) {
        try {
            String apiURL = appProperties.getApiURL().replace("YOUR_DEFAULT_CITY", city);
            ResponseEntity<JsonNode> response = restTemplate.exchange(apiURL, HttpMethod.GET, null, JsonNode.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                JsonNode root = response.getBody();
                ArrayList<String> weatherTemp = new ArrayList<>();
                ArrayList<String> weatherDescript = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    assert root != null;
                    double temp = Double.parseDouble(root.path("list").path(i * 8).path("main").path("temp").asText());
                    weatherTemp.add((int) Math.ceil(temp) + "");//0+16
                    weatherDescript.add(root.path("list").path(i * 8 + 1).path("weather").get(0).path("description").asText());
                }

                weatherTemp.add("no data");
                weatherTemp.add("no data");
                weatherDescript.add("no data");
                weatherDescript.add("no data");
                ArrayList<WeatherModel> weatherModels = new ArrayList<>();
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 7; j++) {
                        weatherModels.add(new WeatherModel(weatherTemp.get(j), weatherDescript.get(j)));
                    }
                }
                return weatherModels;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}