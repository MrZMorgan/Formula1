package ua.com.foxminded;

import ua.com.foxminded.facade.Facade;
import ua.com.foxminded.util.CustomFormatter;


public class Solution {
    public static void main(String[] args) {
        Facade facade = new Facade(new CustomFormatter());
        facade.printResultOfQualification();
    }
}
