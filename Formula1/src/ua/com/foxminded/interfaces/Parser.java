package ua.com.foxminded.interfaces;

import ua.com.foxminded.racer.Racer;

import java.text.ParseException;
import java.util.List;
import java.util.regex.Pattern;

public interface Parser {
    String parse(Pattern pattern, String line);
    long parse(String line) throws ParseException;
    List<Racer> parse(List<String> startLogLines,
                      List<String> endLogLines,
                      List<String> abbreviationsLines) throws ParseException;
}
