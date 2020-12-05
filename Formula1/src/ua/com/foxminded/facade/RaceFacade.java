package ua.com.foxminded.facade;

import ua.com.foxminded.interfaces.Formatable;
import ua.com.foxminded.interfaces.Parseble;
import ua.com.foxminded.interfaces.Readeble;
import ua.com.foxminded.racer.Racer;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class RaceFacade {

    private final Formatable formatable;
    private final Readeble reader;
    private final Parseble parser;

    public RaceFacade(Formatable formatable, Readeble reader, Parseble parser) {
        this.formatable = formatable;
        this.reader = reader;
        this.parser = parser;
    }

    public void printResultOfQualification(String startFileName,
                                           String endFileName,
                                           String abbreviationsFileName) {
        List<Racer> racers = new LinkedList<>();
        try {
            racers = formatable.generateUnformattedRacersList(startFileName, endFileName, abbreviationsFileName, reader, parser);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> qualificationResults = formatable.formatRacerResultList(racers);
        qualificationResults.forEach(System.out::println);
    }
}
