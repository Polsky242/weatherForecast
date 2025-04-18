package myProject.weatherForecAst.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import myProject.weatherForecAst.models.CityModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityJsonService {
    public String citiesJson() {
        List<CityModel> cities = List.of(
                new CityModel(1L, "Moscow", "Europe/Moscow"),
                new CityModel(2L, "Saint Petersburg", "Europe/Samara"),
                new CityModel(3L, "Novosibirsk", "Asia/Novosibirsk"),
                new CityModel(4L, "Yekaterinburg", "Asia/Yekaterinburg"),
                new CityModel(5L, "Nizhny Novgorod", "Europe/Moscow"),
                new CityModel(7L, "Paris", "Europe/Paris"),
                new CityModel(8L, "Berlin", "Europe/Berlin"),
                new CityModel(9L, "Istanbul", "Europe/Istanbul"),
                new CityModel(10L, "Shanghai", "Asia/Shanghai"),
                new CityModel(11L, "Tokyo", "Asia/Tokyo"),
                new CityModel(12L, "Beijing", "Asia/Shanghai"),
                new CityModel(13L, "Seoul", "Asia/Seoul"),
                new CityModel(14L, "Paris", "Europe/Paris"),
                new CityModel(15L, "New York City", "America/New_York"),
                new CityModel(16L, "Tokyo", "Asia/Tokyo"),
                new CityModel(17L, "London", "Europe/London"),
                new CityModel(18L, "Dubai", "Asia/Dubai"),
                new CityModel(19L, "Singapore", ""),
                new CityModel(20L, "Bangkok", "Asia/Bangkok"),
                new CityModel(21L, "Rome", "Europe/Rome"),
                new CityModel(22L, "Istanbul", "Europe/Istanbul"),
                new CityModel(23L, "Prague", "Europe/Prague"),
                new CityModel(24L, "Amsterdam", "Europe/Amsterdam"),
                new CityModel(25L, "Barcelona", "Europe/Madrid"),
                new CityModel(26L, "Seoul", "Asia/Seoul"),
                new CityModel(27L, "Sydney", "Australia/Sydney"),
                new CityModel(28L, "Berlin", "Europe/Berlin"),
                new CityModel(30L, "San Francisco", "America/Los_Angeles"),
                new CityModel(31L, "Venice", "Europe/Rome"),
                new CityModel(32L, "Kyoto", "Asia/Tokyo"),
                new CityModel(33L, "Rio de Janeiro", "America/Sao_Paulo")
        );
        try {
            ObjectMapper mapper = new ObjectMapper();//TODO remove
            return mapper.writeValueAsString(cities);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while processing the request.";
        }
    }
}
