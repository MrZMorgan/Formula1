package ua.com.foxminded;

import ua.com.foxminded.facade.RaceFacade;
import ua.com.foxminded.util.formatter.TopRacersFormatter;
import ua.com.foxminded.util.parser.RacerParser;
import ua.com.foxminded.util.reader.RacerReader;
import static ua.com.foxminded.Main.readLine;

public class Solution {

    public static void main(String[] args) {
        RaceFacade facade = new RaceFacade(new TopRacersFormatter(), new RacerReader(), new RacerParser());
        facade.printResultOfQualification(readLine(), readLine(), readLine());
    }
}
