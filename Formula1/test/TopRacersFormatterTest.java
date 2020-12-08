import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.racer.Racer;
import ua.com.foxminded.util.formatter.TopRacersFormatter;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TopRacersFormatterTest {

    TopRacersFormatter formatter;
    private final static String ACTUAL_RESULT = "2  | Daniel Ricciardo | RED BULL RACING TAG HEUER | 01:12.013";

    @BeforeEach
    void setUp() {
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

        String expectedResult = formatter.formatRacerResult(racer, racerPosition,
                maxLengthOfRacerPosition, maxLengthOfFullName, maxLengthOfTeamName);
        assertEquals(expectedResult, ACTUAL_RESULT);
    }

    @Test
    void shouldFormatRacerResultList() {
        List<String> expectedResult = generateExpectedFormattedRacersList();

        List<Racer> racers = generateExpectedUnformattedRacersList();
        List<String> actualResult = formatter.format(racers);

        assertEquals(expectedResult, actualResult);
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