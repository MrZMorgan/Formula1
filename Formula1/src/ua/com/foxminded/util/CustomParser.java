package ua.com.foxminded.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomParser {
    public static final Pattern RACER_ABBREVIATION = Pattern.compile("^[A-Z]{3}");
    public static final Pattern FULL_NAME = Pattern.compile("[A-Z][a-z]+ [A-Z][a-z]+");
    public static final Pattern TEAM_NAME = Pattern.compile("([A-Z]+ )*[A-Z]+$");
    public static final Pattern DATE_TIME = Pattern.compile("\\d+-\\d+-\\d+_\\d+:\\d+:\\d+\\.\\d+");
    private static final SimpleDateFormat SIMPLE_DATE
            = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");

    public static String parseLine(Pattern pattern, String line) {
        StringBuilder builder = new StringBuilder();

        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            builder.append(line, matcher.start(), matcher.end());
        }

        return builder.toString();
    }

    public static long parseDate(String line) throws ParseException {
        return SIMPLE_DATE.parse(parseLine(DATE_TIME, line)).getTime();
    }
}
