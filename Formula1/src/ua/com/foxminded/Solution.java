package ua.com.foxminded;

import ua.com.foxminded.facade.Facade;
import ua.com.foxminded.formatter.CustomFormatter;
import static ua.com.foxminded.util.CustomReader.readLine;


public class Solution {
    public static void main(String[] args) {
        Facade facade = new Facade(new CustomFormatter());
        facade.printResultOfQualification(readLine(), readLine(), readLine());
    }
}
