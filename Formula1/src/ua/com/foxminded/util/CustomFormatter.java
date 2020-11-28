package ua.com.foxminded.util;

import ua.com.foxminded.racer.Racer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomFormatter {
    private static final DateFormat FORMAT = new SimpleDateFormat("mm:ss.SSS");

    public static String formatResultLine(Racer racer, int racerPosition) {

        String fullName = racer.getFullName();
        String team = racer.getTeam();
        long bestLapTime = racer.getBestLapTime();
        String lapTime = FORMAT.format(new Date(bestLapTime));

        return String.format("%d. %s | %s | %s", racerPosition, fullName, team, lapTime);
    }
}
