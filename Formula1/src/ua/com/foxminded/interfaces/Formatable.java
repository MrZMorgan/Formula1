package ua.com.foxminded.interfaces;

import ua.com.foxminded.racer.Racer;

import java.text.ParseException;
import java.util.List;

public interface Formatable {

    String formatResultLine(Racer racer,
                            int racerPosition,
                            int maxLengthOfRacerPosition,
                            int maxLengthOfFullName,
                            int maxLengthOfTeamName);

    List<String> formatRacerResultList(List<Racer> racers);

    List<Racer> generateUnformattedRacersList(String start, String end, String abbreviations) throws ParseException;
}
