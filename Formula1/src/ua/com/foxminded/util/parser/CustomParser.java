package ua.com.foxminded.util.parser;

import ua.com.foxminded.interfaces.Parser;
import ua.com.foxminded.racer.Racer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomParser implements Parser {

    public static final Pattern RACER_ABBREVIATION = Pattern.compile("^[A-Z]{3}");
    public static final Pattern FULL_NAME = Pattern.compile("[A-Z][a-z]+ [A-Z][a-z]+");
    public static final Pattern TEAM_NAME = Pattern.compile("([A-Z]+ )*[A-Z]+$");
    public static final Pattern DATE_TIME = Pattern.compile("\\d+-\\d+-\\d+_\\d+:\\d+:\\d+\\.\\d+");
    private static final SimpleDateFormat SIMPLE_DATE
            = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");

    public String parse(Pattern pattern, String line) {
        StringBuilder builder = new StringBuilder();

        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            builder.append(line, matcher.start(), matcher.end());
        }

        return builder.toString();
    }

    @Override
    public List<Racer> parse(List<String> startLogLines,
                             List<String> endLogLines,
                             List<String> abbreviationsLines) throws ParseException {
        List<Racer> racerList = new LinkedList<>();

        Collections.sort(startLogLines);
        Collections.sort(endLogLines);
        Collections.sort(abbreviationsLines);

        for (int i = 0; i < abbreviationsLines.size(); i++) {
            Racer racer = new Racer();
            racer.setRacerAbbreviation(parse(RACER_ABBREVIATION, abbreviationsLines.get(i)));
            racer.setFullName(parse(FULL_NAME, abbreviationsLines.get(i)));
            racer.setTeam(parse(TEAM_NAME, abbreviationsLines.get(i)));

            String startTime = parse(DATE_TIME, startLogLines.get(i));
            String endTime = parse(DATE_TIME, endLogLines.get(i));

            long lapTime = SIMPLE_DATE.parse(endTime).getTime() - SIMPLE_DATE.parse(startTime).getTime();
            racer.setBestLapTime(lapTime);
            racerList.add(racer);
        }

        racerList = racerList.stream()
                .sorted(Comparator.comparing(Racer::getBestLapTime))
                .collect(Collectors.toList());

        return racerList;
    }
}
