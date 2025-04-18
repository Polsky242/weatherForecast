package myProject.weatherForecAst.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherModel {
    private final String weather;
    private final String description;
}
