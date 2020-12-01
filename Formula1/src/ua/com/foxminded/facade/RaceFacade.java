package ua.com.foxminded.facade;

import ua.com.foxminded.interfaces.Formatable;
import ua.com.foxminded.racer.Racer;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class RaceFacade {
    private final Formatable formatable;
    public RaceFacade(Formatable formatable) {
        this.formatable = formatable;
    }

    public void printResultOfQualification(String startFileName,
                                           String endFileName,
                                           String abbreviationsFileName) {
        List<Racer> racers = new LinkedList<>();
        try {
            racers = formatable.generateUnformattedRacersList(startFileName, endFileName, abbreviationsFileName);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> qualificationResults = formatable.formatRacerResultList(racers);

        qualificationResults.forEach(System.out::println);
    }
}
