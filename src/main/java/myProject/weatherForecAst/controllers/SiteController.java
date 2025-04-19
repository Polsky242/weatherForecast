package myProject.weatherForecAst.controllers;

import lombok.RequiredArgsConstructor;
import myProject.weatherForecAst.service.impl.ClientDateService;
import myProject.weatherForecAst.models.DateComponent;
import myProject.weatherForecAst.service.impl.ApiDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class SiteController {

    private final ApiDataService apiDataService;
    private final DateComponent dateModel;
    private final ClientDateService clientDate;

    @GetMapping
    public String getMainPage(Model model, @RequestParam(value = "city", required = false, defaultValue = "Moscow") String city) {
        model.addAttribute("apiData", apiDataService.getDataFromApi(city));
        model.addAttribute("exception", apiDataService.getDataFromApi(city).size());
        model.addAttribute("days", dateModel.getDays());
        model.addAttribute("curCity", city);
        model.addAttribute("numOfDayOfTheWeek", clientDate.clientDate(city));
        return "pages/Weather";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "pages/About";
    }
}
