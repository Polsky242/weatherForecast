package myProject.weatherForecAst.models;

public class WeatherModel {
    private final String weather;
    private final String description;

    public WeatherModel(String weather, String description) {
        this.weather = weather;
        this.description = description;
    }

    public String getWeather() {
        return weather;
    }

    public String getDescription() {
        return description;
    }

}
