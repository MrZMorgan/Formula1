package ua.com.foxminded.racer;

import java.text.ParseException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static ua.com.foxminded.util.CustomParser.*;
import static ua.com.foxminded.util.CustomParser.parseDate;
import static ua.com.foxminded.util.CustomReader.readAndCollectLinesFomFile;

public class Racer implements Comparable<Racer> {
    private String racerAbbreviation;
    private String fullName;
    private String team;
    private long bestLapTime;

    public static List<Racer> generateUnformattedRacersList(String start, String end, String abbreviations) throws ParseException {
        List<Racer> racerList = new LinkedList<>();

        List<String> startLogLines = readAndCollectLinesFomFile(start);
        List<String> endLogLines = readAndCollectLinesFomFile(end);
        List<String> abbreviationsLines = readAndCollectLinesFomFile(abbreviations);

        Collections.sort(startLogLines);
        Collections.sort(endLogLines);
        Collections.sort(abbreviationsLines);

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

        racerList.sort(Racer::compareTo);
        return racerList;
    }

    public String getRacerAbbreviation() {
        return racerAbbreviation;
    }

    public void setRacerAbbreviation(String racerAbbreviation) {
        this.racerAbbreviation = racerAbbreviation;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public long getBestLapTime() {
        return bestLapTime;
    }

    public void setBestLapTime(long bestLapTime) {
        this.bestLapTime = bestLapTime;
    }

    @Override
    public String toString() {
        return "Racer{" +
                "racerAbbreviation='" + racerAbbreviation + '\'' +
                ", fullName='" + fullName + '\'' +
                ", team='" + team + '\'' +
                ", bestLapTime='" + bestLapTime + '\'' +
                '}';
    }

    @Override
    public int compareTo(Racer racer) {
        if (this.bestLapTime > racer.getBestLapTime()) {
            return 1;
        } else if (this.bestLapTime < racer.getBestLapTime()) {
            return -1;
        } else {
            return 1;
        }
    }
}
