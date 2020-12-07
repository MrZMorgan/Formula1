import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.racer.Racer;
import ua.com.foxminded.util.parser.CustomParser;
import static ua.com.foxminded.util.parser.CustomParser.*;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomParserTest {

    private CustomParser parser;

    private static final String INPUT_STRING_FOR_PARSE_LINE = "DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER";
    private static final String EXPECTED_TEAM_NAME = "RED BULL RACING TAG HEUER";
    private static final String EXPECTED_ABBREVIATION = "DRR";
    private static final String EXPECTED_FULL_NAME = "Daniel Ricciardo";
    private static final String INPUT_STRING_FOR_PARSE_DATE = "SVF2018-05-24_12:02:58.917";
    private static final String EXPECTED_PARSE_RESULT = "2018-05-24_12:02:58.917";

    @BeforeEach
    void setUp() {
        parser = new CustomParser();
    }

    @Test
    void shouldParseLine() {
        String actualTeamName = parser.parse(TEAM_NAME, INPUT_STRING_FOR_PARSE_LINE);
        String actualAbbreviation = parser.parse(RACER_ABBREVIATION, INPUT_STRING_FOR_PARSE_LINE);
        String actualFullName = parser.parse(FULL_NAME, INPUT_STRING_FOR_PARSE_LINE);

        assertEquals(EXPECTED_TEAM_NAME, actualTeamName);
        assertEquals(EXPECTED_ABBREVIATION, actualAbbreviation);
        assertEquals(EXPECTED_FULL_NAME, actualFullName);
    }

    @Test
    void shouldParseDate() {
        String actualParseResult = parser.parse(DATE_TIME, INPUT_STRING_FOR_PARSE_DATE);

        assertEquals(EXPECTED_PARSE_RESULT, actualParseResult);
    }

    @Test
    void shouldGenerateUnformattedRacersList() throws ParseException {
        List<Racer> expectedResult = generateExpectedUnformattedRacersList();

        List<Racer> actualResult = parser.parse(lineFromStartLog(),
                linesFromEndLog(), linesFromAbbreviationFile());

        assertEquals(expectedResult, actualResult);
    }

    List<Racer> generateExpectedUnformattedRacersList() {
        List<Racer> expectedResult = new LinkedList<>();

        Racer racer1 = new Racer();
        racer1.setRacerAbbreviation("SVF");
        racer1.setTeam("FERRARI");
        racer1.setFullName("Sebastian Vettel");
        racer1.setBestLapTime(64415L);

        Racer racer2 = new Racer();
        racer2.setRacerAbbreviation("FAM");
        racer2.setTeam("MCLAREN RENAULT");
        racer2.setFullName("Fernando Alonso");
        racer2.setBestLapTime(72657L);

        Racer racer3 = new Racer();
        racer3.setRacerAbbreviation("NHR");
        racer3.setTeam("RENAULT");
        racer3.setFullName("Nico Hulkenberg");
        racer3.setBestLapTime(73065L);

        expectedResult.add(racer1);
        expectedResult.add(racer2);
        expectedResult.add(racer3);

        return expectedResult;
    }

    List<String> lineFromStartLog() {
        List<String> lines = new LinkedList<>();
        lines.add("SVF2018-05-24_12:02:58.917");
        lines.add("NHR2018-05-24_12:02:49.914");
        lines.add("FAM2018-05-24_12:13:04.512");
        return lines;
    }

    List<String> linesFromEndLog() {
        List<String> lines = new LinkedList<>();
        lines.add("SVF2018-05-24_12:04:03.332");
        lines.add("FAM2018-05-24_12:14:17.169");
        lines.add("NHR2018-05-24_12:04:02.979");
        return lines;
    }

    List<String> linesFromAbbreviationFile() {
        List<String> lines = new LinkedList<>();
        lines.add("NHR_Nico Hulkenberg_RENAULT");
        lines.add("SVF_Sebastian Vettel_FERRARI");
        lines.add("FAM_Fernando Alonso_MCLAREN RENAULT");
        return lines;
    }

}