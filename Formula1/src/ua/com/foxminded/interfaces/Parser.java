package ua.com.foxminded.interfaces;

import ua.com.foxminded.racer.Racer;
import java.text.ParseException;
import java.util.List;

public interface Parser {

    List<Racer> parse(List<String> startLogLines,
                      List<String> endLogLines,
                      List<String> abbreviationsLines) throws ParseException;
}
