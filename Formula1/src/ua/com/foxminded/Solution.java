package ua.com.foxminded;

import ua.com.foxminded.facade.RaceFacade;
import ua.com.foxminded.formatter.CustomFormatter;
import static ua.com.foxminded.util.CustomReader.readLine;


public class Solution {
    public static void main(String[] args) {
        RaceFacade facade = new RaceFacade(new CustomFormatter());
        facade.printResultOfQualification(readLine(), readLine(), readLine());
    }
}
