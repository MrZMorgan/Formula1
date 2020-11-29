package ua.com.foxminded.formatter;

import ua.com.foxminded.interfaces.Formatable;
import ua.com.foxminded.racer.Racer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CustomFormatter implements Formatable {
    private static final DateFormat FORMAT = new SimpleDateFormat("mm:ss.SSS");
    private static final String SEPARATOR = "-";

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
            formattedLine.append(" ");
        }
        formattedLine.append(" | ");
        formattedLine.append(fullName);
        for (int i = 0; i < maxLengthOfFullName - fullName.length(); i++) {
            formattedLine.append(" ");
        }
        formattedLine.append(" | ");
        formattedLine.append(teamName);
        for (int i = 0; i < maxLengthOfTeamName - teamName.length(); i++) {
            formattedLine.append(" ");
        }
        formattedLine.append(" | ");
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

    private String createQualificationLine(List<String> qualificationResults) {
        int maxLengthOfResultLine = 0;

        for (int i = 0; i < qualificationResults.size(); i++) {
            if (qualificationResults.get(i).length() > maxLengthOfResultLine) {
                maxLengthOfResultLine = qualificationResults.get(i).length();
            }
        }

        StringBuilder qualificationLine = new StringBuilder();
        for (int i = 0; i < maxLengthOfResultLine; i++) {
            qualificationLine.append(SEPARATOR);
        }
        return qualificationLine.toString();
    }
}
