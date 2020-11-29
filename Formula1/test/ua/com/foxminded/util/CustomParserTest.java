package ua.com.foxminded.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static ua.com.foxminded.util.CustomParser.*;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class CustomParserTest {
    private static final String inputStringForParseLine = "DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER";
    private static final String expectedTeamName = "RED BULL RACING TAG HEUER";
    private static final String expectedAbbreviation = "DRR";
    private static final String expectedFullName = "Daniel Ricciardo";

    private static final String inputStringForParseDate = "SVF2018-05-24_12:02:58.917";
    private static final long expectedParseResult = 1527152578917L;

    @Test
    void shouldParseLine() {
        String actualTeamName = parseLine(TEAM_NAME, inputStringForParseLine);
        String actualAbbreviation = parseLine(RACER_ABBREVIATION, inputStringForParseLine);
        String actualFullName = parseLine(FULL_NAME, inputStringForParseLine);

        assertEquals(expectedTeamName, actualTeamName);
        assertEquals(expectedAbbreviation, actualAbbreviation);
        assertEquals(expectedFullName, actualFullName);
    }

    @Test
    void shouldParseDate() throws ParseException {
        long actualParseResult = CustomParser.parseDate(inputStringForParseDate);

        assertEquals(expectedParseResult, actualParseResult);
    }
}