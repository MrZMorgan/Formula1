package ua.com.foxminded.racer;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Racer)) return false;
        Racer racer = (Racer) o;
        return getBestLapTime() == racer.getBestLapTime() &&
                getRacerAbbreviation().equals(racer.getRacerAbbreviation()) &&
                getFullName().equals(racer.getFullName()) &&
                getTeam().equals(racer.getTeam());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRacerAbbreviation(), getFullName(), getTeam(), getBestLapTime());
    }
}
