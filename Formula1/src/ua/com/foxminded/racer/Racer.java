package ua.com.foxminded.racer;

import java.util.Date;

public class Racer {
    private String racerAbbreviation;
    private String fullName;
    private String team;
    private String bestLapTime;

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

    public String getBestLapTime() {
        return bestLapTime;
    }

    public void setBestLapTime(String bestLapTime) {
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
}
