package myProject.weatherForecAst.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import myProject.weatherForecAst.models.WeatherModel;
import myProject.weatherForecAst.properties.RestWeatherProp;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiDataService {
    private final RestTemplate restTemplate;
    private final RestWeatherProp restWeatherProp;

    public ApiDataService(RestTemplate restTemplate, RestWeatherProp restWeatherProp) {
        this.restTemplate = restTemplate;
        this.restWeatherProp = restWeatherProp;
    }

    public ArrayList<WeatherModel> getDataFromApi(String city) {
        try {
            String apiURL = restWeatherProp.getApiURL().replace("YOUR_DEFAULT_CITY", city);
            ResponseEntity<JsonNode> response = restTemplate.exchange(apiURL, HttpMethod.GET, null, JsonNode.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                JsonNode root = response.getBody();
                ArrayList<String> weatherTemp = new ArrayList<>();
                ArrayList<String> weatherDescript = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    assert root != null;
                    double temp = Double.parseDouble(root.path("list").path(i * 8).path("main").path("temp").asText());
                    weatherTemp.add((int) Math.ceil(temp) + "");
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
                return new ArrayList<>(List.of(
                        new WeatherModel("no such city:" + city, "No such city:" + city)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(List.of(
                    new WeatherModel("no such city:" + city, "No such city:" + city)));
        }
    }
}