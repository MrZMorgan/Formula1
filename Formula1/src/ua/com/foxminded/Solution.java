package ua.com.foxminded;

import ua.com.foxminded.racer.Racer;
import ua.com.foxminded.racer.RacersTable;

import java.io.File;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static ua.com.foxminded.util.CustomParser.*;
import static ua.com.foxminded.util.CustomReader.*;

public class Solution {
    public static void main(String[] args) throws ParseException {
        String startFile = readLine();
//        File start = new File(readLine());
//        List<String> startLog = readAndCollectLinesFomFile(start);

        String endFile = readLine();
//        File end = new File(readLine());
//        List<String> endLog = readAndCollectLinesFomFile(end);

        String abbreviationsFile = readLine();
//        File abbreviations = new File(readLine());
//        List<String> abbreviationsList = readAndCollectLinesFomFile(abbreviations);

//        for (int i = 0; i < startLog.size(); i++) {
//            Date startTime = parseDate(startLog.get(i));
//            Date endTime = parseDate(endLog.get(i));
//
//            System.out.println(startTime + " | " + endTime);
//
//            DateFormat format = new SimpleDateFormat("mm:ss.SSS");
//
//            String lapTime = format.format(new Date(startTime.getTime() - endTime.getTime()));
//            System.out.println(lapTime);
//        }

//        for (int i = 0; i < startLog.size(); i++) {
//            System.out.println(startLog.get(i) + " | " + endLog.get(i) + " | " + abbreviationsList.get(i));
//            System.out.println("------------------------------------------------------------------------------");
//        }

        RacersTable table = new RacersTable();
        List<Racer> racers = table.createRacersList(startFile, endFile, abbreviationsFile);

        for (Racer racer : racers) {
            System.out.println(racer.toString());
        }
    }
}
