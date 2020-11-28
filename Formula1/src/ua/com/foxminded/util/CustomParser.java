package ua.com.foxminded.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomParser {
    public static final Pattern SVF_PATTERN = Pattern.compile("^[A-Z]{3}");
    public static final Pattern FULL_NAME_PATTERN = Pattern.compile("[A-Z][a-z]+ [A-Z][a-z]+");
    public static final Pattern TEAM_NAME_PATTERN = Pattern.compile("([A-Z]+ ){1,}[A-Z]+");
    public static final Pattern DATE_TIME_PATTERN = Pattern.compile("(\\d|\\B|-|\\.|_|:)+");
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT
            = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");

    public static String parseLine(Pattern pattern, String line) {
        StringBuilder builder = new StringBuilder();

        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            builder.append(line.substring(matcher.start(), matcher.end()));
        }

        return builder.toString();
    }

    public static Date parseDate(String stringDateRepresentation) throws ParseException {
        return SIMPLE_DATE_FORMAT.parse(stringDateRepresentation);
    }
}
