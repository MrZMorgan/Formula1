package ua.com.foxminded.interfaces;

import ua.com.foxminded.racer.Racer;

import java.text.ParseException;
import java.util.List;

public interface Formatter {

    String formatResultLine(Racer racer,
                            int racerPosition,
                            int maxLengthOfRacerPosition,
                            int maxLengthOfFullName,
                            int maxLengthOfTeamName);

    List<String> formatRacerResultList(List<Racer> racers);

    List<Racer> generateUnformattedRacersList(List<String> startLogLines,
                                              List<String> endLogLines,
                                              List<String> abbreviationsLines,
                                              Parseble parser) throws ParseException;
}
