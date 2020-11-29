package ua.com.foxminded.facade;

import ua.com.foxminded.interfaces.Formatable;
import ua.com.foxminded.racer.Racer;
import ua.com.foxminded.racer.RacersTable;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import static ua.com.foxminded.util.CustomReader.readLine;

public class Facade {
    private final Formatable formatable;
    private static final String SEPARATOR = "-------------------------------------------------------------";
    public Facade(Formatable formatable) {
        this.formatable = formatable;
    }

    public void printResultOfQualification() {
        String startFileName = readLine();
        String endFileName = readLine();
        String abbreviationsFileName = readLine();

        RacersTable table = new RacersTable();
        List<Racer> racers = new LinkedList<>();
        try {
            racers = table.createRacersList(startFileName, endFileName, abbreviationsFileName);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        racers.sort(Racer::compareTo);

        for (int i = 0; i < racers.size(); i++) {
            if (i == 15) {
                System.out.println(SEPARATOR);
            }
            System.out.println(formatable.formatResultLine(racers.get(i), i + 1));
        }
    }
}
