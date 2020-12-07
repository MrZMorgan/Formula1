package ua.com.foxminded.util.formatter;

import ua.com.foxminded.interfaces.Formatter;
import ua.com.foxminded.racer.Racer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TopRacersFormatter implements Formatter {

    private static final DateFormat FORMAT = new SimpleDateFormat("mm:ss.SSS");
    private static final String HORIZONTAL_SEPARATOR = "-";
    private static final String VERTICAL_SEPARATOR = "|";
    private static final String SPACE = " ";

    @Override
    public String format(Racer racer,
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

    @Override
    public List<String> format(List<Racer> racers) {
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
            qualificationResults.add(format(racers.get(i), i + 1,
                    maxLengthOfRacerPosition, maxLengthOfFullName, maxLengthOfTeamName));
        }

        String qualificationLine = createQualificationLine(qualificationResults);

        if (racers.size() > 15) {
            qualificationResults.add(15, qualificationLine);
        }

        return qualificationResults;
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
