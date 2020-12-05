package ua.com.foxminded.interfaces;

import java.text.ParseException;
import java.util.regex.Pattern;

public interface Parseble {
    String parseLine(Pattern pattern, String line);
    long parseDate(String line) throws ParseException;
}
