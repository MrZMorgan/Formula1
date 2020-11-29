package ua.com.foxminded.util;

import org.junit.jupiter.api.Test;
import static ua.com.foxminded.util.CustomParser.*;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class CustomParserTest {
    private static final String INPUT_STRING_FOR_PARSE_LINE = "DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER";
    private static final String EXPECTED_TEAM_NAME = "RED BULL RACING TAG HEUER";
    private static final String EXPECTED_ABBREVIATION = "DRR";
    private static final String EXPECTED_FULL_NAME = "Daniel Ricciardo";

    private static final String INPUT_STRING_FOR_PARSE_DATE = "SVF2018-05-24_12:02:58.917";
    private static final long EXPECTED_PARSE_RESULT = 1527152578917L;

    @Test
    void shouldParseLine() {
        String actualTeamName = parseLine(TEAM_NAME, INPUT_STRING_FOR_PARSE_LINE);
        String actualAbbreviation = parseLine(RACER_ABBREVIATION, INPUT_STRING_FOR_PARSE_LINE);
        String actualFullName = parseLine(FULL_NAME, INPUT_STRING_FOR_PARSE_LINE);

        assertEquals(EXPECTED_TEAM_NAME, actualTeamName);
        assertEquals(EXPECTED_ABBREVIATION, actualAbbreviation);
        assertEquals(EXPECTED_FULL_NAME, actualFullName);
    }

    @Test
    void shouldParseDate() throws ParseException {
        long actualParseResult = CustomParser.parseDate(INPUT_STRING_FOR_PARSE_DATE);

        assertEquals(EXPECTED_PARSE_RESULT, actualParseResult);
    }
}