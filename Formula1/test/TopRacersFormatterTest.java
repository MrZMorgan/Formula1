import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.interfaces.Formatter;
import ua.com.foxminded.interfaces.Parser;
import ua.com.foxminded.racer.Racer;
import ua.com.foxminded.util.formatter.TopRacersFormatter;
import ua.com.foxminded.util.parser.CustomParser;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TopRacersFormatterTest {

    private Formatter formatter;
    private Parser parser;
    private final static String ACTUAL_RESULT = "2  | Daniel Ricciardo | RED BULL RACING TAG HEUER | 01:12.013";

    @BeforeEach
    void setUp() {
        parser = new CustomParser();
        formatter = new TopRacersFormatter();
    }

    @Test
    void shouldFormatResultLine() {
        Racer racer = new Racer();
        racer.setRacerAbbreviation("DRR");
        racer.setFullName("Daniel Ricciardo");
        racer.setTeam("RED BULL RACING TAG HEUER");
        racer.setBestLapTime(72013L);

        int racerPosition = 2;
        int maxLengthOfRacerPosition = 2;
        int maxLengthOfFullName = 16;
        int maxLengthOfTeamName = 25;

        String expectedResult = formatter.formatResultLine(racer, racerPosition,
                maxLengthOfRacerPosition, maxLengthOfFullName, maxLengthOfTeamName);
        assertEquals(expectedResult, ACTUAL_RESULT);
    }

    @Test
    void shouldGenerateUnformattedRacersList() throws ParseException {
        List<Racer> expectedResult = generateExpectedUnformattedRacersList();

        List<Racer> actualResult = formatter.generateUnformattedRacersList(lineFromStartLog(),
                linesFromEndLog(), linesFromAbbreviationFile(), parser);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldFormatRacerResultList() {
        List<String> expectedResult = generateExpectedFormattedRacersList();

        List<Racer> racers = generateExpectedUnformattedRacersList();
        List<String> actualResult = formatter.formatRacerResultList(racers);

        assertEquals(expectedResult, actualResult);
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

    List<String> generateExpectedFormattedRacersList() {
        List<String> expectedResult = new LinkedList<>();
        expectedResult.add("1 | Sebastian Vettel | FERRARI         | 01:04.415");
        expectedResult.add("2 | Fernando Alonso  | MCLAREN RENAULT | 01:12.657");
        expectedResult.add("3 | Nico Hulkenberg  | RENAULT         | 01:13.065");
        return expectedResult;
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
}