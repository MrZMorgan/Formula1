package ua.com.foxminded.util;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class CustomParserTest {

    @Test
    void parseLine() {

    }

    @Test
    void shouldParseDate() throws ParseException {
        String inputString = "SVF2018-05-24_12:02:58.917";

        long expectedParseResult = 1527152578917L;
        long actualParseResult = CustomParser.parseDate(inputString);

        assertEquals(expectedParseResult, actualParseResult);
    }
}