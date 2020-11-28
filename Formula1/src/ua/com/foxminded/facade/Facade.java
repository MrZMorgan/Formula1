package ua.com.foxminded.facade;

import ua.com.foxminded.racer.Racer;
import ua.com.foxminded.racer.RacersTable;

import java.text.ParseException;
import java.util.List;

import static ua.com.foxminded.util.CustomFormatter.formatResultLine;
import static ua.com.foxminded.util.CustomReader.readLine;

public class Facade {
    public void printResultOfQualification() throws ParseException {
        String startFileName = readLine();
        String endFileName = readLine();
        String abbreviationsFileName = readLine();

        RacersTable table = new RacersTable();
        List<Racer> racers = table.createRacersList(startFileName, endFileName, abbreviationsFileName);

        racers.sort(Racer::compareTo);

        for (int i = 0; i < racers.size(); i++) {
            if (i == 15) {
                System.out.println("-------------------------------------------------------------");
            }
            System.out.println(formatResultLine(racers.get(i), i + 1));
        }
    }
}
