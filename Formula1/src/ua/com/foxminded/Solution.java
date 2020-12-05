package ua.com.foxminded;

import ua.com.foxminded.facade.RaceFacade;
import ua.com.foxminded.util.formatter.CustomFormatter;
import ua.com.foxminded.util.parser.CustomParser;
import ua.com.foxminded.util.reader.CustomReader;

import static ua.com.foxminded.Main.readLine;

public class Solution {
    public static void main(String[] args) {
        RaceFacade facade = new RaceFacade(new CustomFormatter(), new CustomReader(), new CustomParser());
        facade.printResultOfQualification(readLine(), readLine(), readLine());
    }
}
