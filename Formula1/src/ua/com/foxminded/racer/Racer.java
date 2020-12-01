package ua.com.foxminded.racer;

import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static ua.com.foxminded.util.CustomParser.*;
import static ua.com.foxminded.util.CustomParser.parseDate;
import static ua.com.foxminded.util.CustomReader.readAndCollectLinesFomFile;

public class Racer {
    private String racerAbbreviation;
    private String fullName;
    private String team;
    private long bestLapTime;

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
}
