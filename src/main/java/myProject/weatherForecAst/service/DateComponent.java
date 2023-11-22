package myProject.weatherForecAst.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class DateComponent {
    public ArrayList<String> getDays() {
        return new ArrayList<>(Arrays.asList(
                "Monday",
                "Tuesday",
                "Wensday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"));
    }
}
