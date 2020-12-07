package ua.com.foxminded.facade;

import ua.com.foxminded.interfaces.Formatter;
import ua.com.foxminded.interfaces.Parser;
import ua.com.foxminded.interfaces.Reader;
import ua.com.foxminded.racer.Racer;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class RaceFacade {

    private final Formatter formatter;
    private final Reader reader;
    private final Parser parser;

    public RaceFacade(Formatter formatter, Reader reader, Parser parser) {
        this.formatter = formatter;
        this.reader = reader;
        this.parser = parser;
    }

    public void printResultOfQualification(String startFileName,
                                           String endFileName,
                                           String abbreviationsFileName) {

        List<String> startLogLines = reader.read(startFileName);
        List<String> endLogLines = reader.read(endFileName);
        List<String> abbreviationsLines = reader.read(abbreviationsFileName);

        List<Racer> racers = new LinkedList<>();
        try {
            racers = parser.parse(startLogLines, endLogLines, abbreviationsLines);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> qualificationResults = formatter.format(racers);
        qualificationResults.forEach(System.out::println);
    }
}
