package myProject.weatherForecAst.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //TODO make entity
@NoArgsConstructor
public class CityModel {
    private Long id;
    private String name;
    private String region;
}
