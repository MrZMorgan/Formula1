package ua.com.foxminded.racer;

import java.text.ParseException;
import java.util.*;
import static ua.com.foxminded.util.CustomReader.*;
import static ua.com.foxminded.util.CustomParser.*;

public class RacersTable {
    public List<Racer> createRacersList(String start, String end, String abbreviations) throws ParseException {
        List<Racer> racerList = new LinkedList<>();

        List<String> startLogLines = readAndCollectLinesFomFile(start);
        List<String> endLogLines = readAndCollectLinesFomFile(end);
        List<String> abbreviationsLines = readAndCollectLinesFomFile(abbreviations);

        for (int i = 0; i < abbreviationsLines.size(); i++) {
            Racer racer = new Racer();
            racer.setRacerAbbreviation(parseLine(RACER_ABBREVIATION, abbreviationsLines.get(i)));
            racer.setFullName(parseLine(FULL_NAME, abbreviationsLines.get(i)));
            racer.setTeam(parseLine(TEAM_NAME, abbreviationsLines.get(i)));

            long startTime = parseDate(startLogLines.get(i));
            long endTime = parseDate(endLogLines.get(i));

            long lapTime = endTime - startTime;
            racer.setBestLapTime(lapTime);
            racerList.add(racer);
        }

        return racerList;
    }


}
