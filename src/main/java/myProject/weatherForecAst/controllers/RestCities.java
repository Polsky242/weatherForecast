package myProject.weatherForecAst.controllers;


import lombok.RequiredArgsConstructor;
import myProject.weatherForecAst.models.City;
import myProject.weatherForecAst.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/API")
@RequiredArgsConstructor
public class RestCities {

    private final CityService cityService;

    @GetMapping("/cities")
    public ResponseEntity<List<City>> getCitiesApi() {
        return ResponseEntity.ok(cityService.getCities());
    }
}
