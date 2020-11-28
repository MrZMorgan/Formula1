package ua.com.foxminded.racer;


import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static ua.com.foxminded.util.CustomReader.*;
import static ua.com.foxminded.util.CustomParser.*;

public class RacersTable {
    private final static DateFormat FORMAT = new SimpleDateFormat("mm:ss.SSS");
    public List<Racer> createRacersList(String start, String end, String abbreviations) throws ParseException {
        List<Racer> racerList = new LinkedList<>();

        List<String> startLogLines = readAndCollectLinesFomFile(new File(start));
        List<String> endLogLines = readAndCollectLinesFomFile(new File(end));
        List<String> abbreviationsLines = readAndCollectLinesFomFile(new File(abbreviations));

        for (int i = 0; i < abbreviationsLines.size(); i++) {
            Racer racer = new Racer();
            racer.setRacerAbbreviation(parseLine(RACER_ABBREVIATION, abbreviationsLines.get(i)));
            racer.setFullName(parseLine(FULL_NAME, abbreviationsLines.get(i)));
            racer.setTeam(parseLine(TEAM_NAME, abbreviationsLines.get(i)));

            Date startTime = parseDate(startLogLines.get(i));
            Date endTime = parseDate(endLogLines.get(i));

            String lapTime = FORMAT.format(new Date(endTime.getTime() - startTime.getTime()));
            racer.setBestLapTime(lapTime);
            racerList.add(racer);
        }

        return racerList;
    }
}
