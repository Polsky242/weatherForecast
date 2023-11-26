package myProject.weatherForecAst.controllers;

import myProject.weatherForecAst.service.ClientDateService;
import myProject.weatherForecAst.models.DateComponent;
import myProject.weatherForecAst.service.ApiDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiteController {
    private final ApiDataService apiDataService;
    private final DateComponent dateModel;
    private final ClientDateService clientDate;

    @Autowired
    public SiteController(ApiDataService apiDataService, DateComponent dateModel, ClientDateService clientDate) {
        this.apiDataService = apiDataService;
        this.dateModel = dateModel;
        this.clientDate = clientDate;
    }

    @RequestMapping
    public String getMainPage(Model model, @RequestParam(value = "city", required = false, defaultValue = "Moscow") String city) {
        model.addAttribute("apiData", apiDataService.getDataFromApi(city));
        model.addAttribute("exception", apiDataService.getDataFromApi(city).size());
        model.addAttribute("days", dateModel.getDays());
        model.addAttribute("curCity", city);
        model.addAttribute("numOfDayOfTheWeek", clientDate.clientDate(city));
        return "pages/Weather";
    }

    @RequestMapping("/about")
    public String getAbout() {
        return "pages/About";
    }
}
