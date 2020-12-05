package ua.com.foxminded.util.formatter;

import ua.com.foxminded.interfaces.Formatable;
import ua.com.foxminded.interfaces.Parseble;
import ua.com.foxminded.interfaces.Readeble;
import ua.com.foxminded.racer.Racer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static ua.com.foxminded.util.parser.CustomParser.*;

public class CustomFormatter implements Formatable {

    private static final DateFormat FORMAT = new SimpleDateFormat("mm:ss.SSS");
    private static final String HORIZONTAL_SEPARATOR = "-";
    private static final String VERTICAL_SEPARATOR = "|";
    private static final String SPACE = " ";

    public String formatResultLine(Racer racer,
                                   int racerPosition,
                                   int maxLengthOfRacerPosition,
                                   int maxLengthOfFullName,
                                   int maxLengthOfTeamName) {
        String fullName = racer.getFullName();
        String teamName = racer.getTeam();
        long bestLapTime = racer.getBestLapTime();
        String lapTime = FORMAT.format(new Date(bestLapTime));

        StringBuilder formattedLine = new StringBuilder();

        formattedLine.append(racerPosition);
        for (int i = 0; i < maxLengthOfRacerPosition - String.valueOf(racerPosition).length(); i++) {
            formattedLine.append(SPACE);
        }
        formattedLine.append(SPACE + VERTICAL_SEPARATOR + SPACE);
        formattedLine.append(fullName);
        for (int i = 0; i < maxLengthOfFullName - fullName.length(); i++) {
            formattedLine.append(SPACE);
        }
        formattedLine.append(SPACE + VERTICAL_SEPARATOR + SPACE);
        formattedLine.append(teamName);
        for (int i = 0; i < maxLengthOfTeamName - teamName.length(); i++) {
            formattedLine.append(SPACE);
        }
        formattedLine.append(SPACE + VERTICAL_SEPARATOR + SPACE);
        formattedLine.append(lapTime);
        return formattedLine.toString();
    }

    public List<String> formatRacerResultList(List<Racer> racers) {
        List<String> qualificationResults = new LinkedList<>();
        int maxLengthOfRacerPosition = String.valueOf(racers.size() + 1).length();
        int maxLengthOfFullName = 0;
        int maxLengthOfTeamName = 0;

        for (Racer racer : racers) {
            if (racer.getFullName().length() > maxLengthOfFullName) {
                maxLengthOfFullName = racer.getFullName().length();
            }
        }

        for (Racer racer : racers) {
            if (racer.getFullName().length() > maxLengthOfTeamName) {
                maxLengthOfTeamName = racer.getTeam().length();
            }
        }

        for (int i = 0; i < racers.size(); i++) {
            qualificationResults.add(formatResultLine(racers.get(i), i + 1,
                    maxLengthOfRacerPosition, maxLengthOfFullName, maxLengthOfTeamName));
        }

        String qualificationLine = createQualificationLine(qualificationResults);

        qualificationResults.add(15, qualificationLine);
        return qualificationResults;
    }

    public List<Racer> generateUnformattedRacersList(String start,
                                                     String end,
                                                     String abbreviations,
                                                     Readeble reader,
                                                     Parseble parser) throws ParseException {
        List<Racer> racerList = new LinkedList<>();

        List<String> startLogLines = reader.readAndCollectLinesFomFile(start);
        List<String> endLogLines = reader.readAndCollectLinesFomFile(end);
        List<String> abbreviationsLines = reader.readAndCollectLinesFomFile(abbreviations);

        Collections.sort(startLogLines);
        Collections.sort(endLogLines);
        Collections.sort(abbreviationsLines);

        for (int i = 0; i < abbreviationsLines.size(); i++) {
            Racer racer = new Racer();
            racer.setRacerAbbreviation(parser.parseLine(RACER_ABBREVIATION, abbreviationsLines.get(i)));
            racer.setFullName(parser.parseLine(FULL_NAME, abbreviationsLines.get(i)));
            racer.setTeam(parser.parseLine(TEAM_NAME, abbreviationsLines.get(i)));

            long startTime = parser.parseDate(startLogLines.get(i));
            long endTime = parser.parseDate(endLogLines.get(i));

            long lapTime = endTime - startTime;
            racer.setBestLapTime(lapTime);
            racerList.add(racer);
        }

        racerList = racerList.stream()
                .sorted(Comparator.comparing(Racer::getBestLapTime))
                .collect(Collectors.toList());

        return racerList;
    }

    private String createQualificationLine(List<String> qualificationResults) {
        int maxLengthOfResultLine = 0;

        for (int i = 0; i < qualificationResults.size(); i++) {
            if (qualificationResults.get(i).length() > maxLengthOfResultLine) {
                maxLengthOfResultLine = qualificationResults.get(i).length();
            }
        }

        StringBuilder qualificationLine = new StringBuilder();
        for (int i = 0; i < maxLengthOfResultLine; i++) {
            qualificationLine.append(HORIZONTAL_SEPARATOR);
        }
        return qualificationLine.toString();
    }
}