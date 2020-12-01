import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.interfaces.Formatable;
import ua.com.foxminded.racer.Racer;
import ua.com.foxminded.formatter.CustomFormatter;

import static org.junit.jupiter.api.Assertions.*;

class CustomFormatterTest {
    private Racer racer;
    private Formatable formatter;
    private final static String ACTUAL_RESULT = "2  | Daniel Ricciardo | RED BULL RACING TAG HEUER | 01:12.013";

    @BeforeEach
    void setUp() {
        racer = new Racer();
        racer.setRacerAbbreviation("DRR");
        racer.setFullName("Daniel Ricciardo");
        racer.setTeam("RED BULL RACING TAG HEUER");
        racer.setBestLapTime(72013L);
        formatter = new CustomFormatter();
    }

    @Test
    void shouldFormatResultLine() {
        int racerPosition = 2;
        int maxLengthOfRacerPosition = 2;
        int maxLengthOfFullName = 16;
        int maxLengthOfTeamName = 25;
        String expectedResult = formatter.formatResultLine(racer, racerPosition,
                maxLengthOfRacerPosition, maxLengthOfFullName, maxLengthOfTeamName);
        assertEquals(expectedResult, ACTUAL_RESULT);
    }
}