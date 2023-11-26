package myProject.weatherForecAst.controllers;


import myProject.weatherForecAst.service.CityJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/API")
public class RestCities {


    private final CityJsonService cityJsonService;

    @Autowired
    public RestCities(CityJsonService cityJsonService) {
        this.cityJsonService = cityJsonService;
    }

    @GetMapping("/cities")
    @ResponseBody
    public String getCitiesApi() {

        return cityJsonService.citiesJson();
    }

}
