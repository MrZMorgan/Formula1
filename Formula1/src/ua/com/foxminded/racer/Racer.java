package ua.com.foxminded.racer;

public class Racer implements Comparable<Racer> {
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
