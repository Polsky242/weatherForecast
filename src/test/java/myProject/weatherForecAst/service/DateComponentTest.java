package myProject.weatherForecAst.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class DateComponentTest {

    @Test
    public void checkIfDaysOfWeekCorrect(){
        DateComponent date=new DateComponent();
        HashMap<Integer,String> map= new HashMap<>();
        for(int i=0;i<7;i++){
            map.put(i,date.getDays().get(i));
        }

        Assertions.assertNotNull(date);
        for (int j=0;j<7;j++) {
            Assertions.assertEquals(map.get(j), date.getDays().get(j));
        }
    }
}
