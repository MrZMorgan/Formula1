package ua.com.foxminded.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomParser {
    public static final Pattern SVF_PATTERN = Pattern.compile("^[A-Z]{3}");
    public static final Pattern FULL_NAME_PATTERN = Pattern.compile("[A-Z][a-z]+ [A-Z][a-z]+");
    public static final Pattern TEAM_NAME_PATTERN = Pattern.compile("([A-Z]+ ){1,}[A-Z]+");
    public static final Pattern DATE_TIME_PATTERN = Pattern.compile("(\\d|\\B|-|\\.|_|:)+");

    public static String parseLine(Pattern pattern, String line) {
        StringBuilder builder = new StringBuilder();

        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            builder.append(line.substring(matcher.start(), matcher.end()));
        }

        return builder.toString();
    }
}
