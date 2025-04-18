package myProject.weatherForecAst.controllers;


import lombok.RequiredArgsConstructor;
import myProject.weatherForecAst.service.CityJsonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/API")
@RequiredArgsConstructor
public class RestCities {

    private final CityJsonService cityJsonService;

    @GetMapping("/cities")
    @ResponseBody
    public String getCitiesApi() {

        return cityJsonService.citiesJson();
    }

}
