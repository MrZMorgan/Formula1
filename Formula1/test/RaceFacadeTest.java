import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import ua.com.foxminded.facade.RaceFacade;
import ua.com.foxminded.interfaces.Formatable;
import ua.com.foxminded.interfaces.Parseble;
import ua.com.foxminded.interfaces.Readeble;
import ua.com.foxminded.racer.Racer;
import ua.com.foxminded.util.parser.CustomParser;
import ua.com.foxminded.util.reader.CustomReader;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.*;

class RaceFacadeTest {

    private Formatable formatterMock;
    private Readeble readerMock;
    private Parseble parserMock;
    private RaceFacade facade;
    private final static String START_LOG_FILE_NAME = "test/filesfortests/start.log";
    private final static String END_LOG_FILE_NAME = "test/filesfortests/end.log";
    private final static String ABBREVIATIONS_FILE_NAME = "test/filesfortests/abbreviations.txt";

    @Test
    void shouldGenerateUnformattedRacersList() throws ParseException {
        formatterMock = mock(Formatable.class);
        readerMock = mock(CustomReader.class);
        parserMock = mock(CustomParser.class);
        facade = new RaceFacade(formatterMock, readerMock, parserMock);

        List<Racer> racers = createListOfRacersForTest();

        when(formatterMock.generateUnformattedRacersList(START_LOG_FILE_NAME,
                END_LOG_FILE_NAME, ABBREVIATIONS_FILE_NAME, readerMock, parserMock)).thenReturn(racers);

        facade.printResultOfQualification(START_LOG_FILE_NAME, END_LOG_FILE_NAME, ABBREVIATIONS_FILE_NAME);

        InOrder inOrder = inOrder(formatterMock);

        inOrder.verify(formatterMock).generateUnformattedRacersList(START_LOG_FILE_NAME,
                END_LOG_FILE_NAME, ABBREVIATIONS_FILE_NAME, readerMock, parserMock);
        inOrder.verify(formatterMock).formatRacerResultList(anyList());
    }

    List<Racer> createListOfRacersForTest() {
        List<Racer> racers = new LinkedList<>();

        Racer racer1 = new Racer();
        racer1.setRacerAbbreviation("SVF");
        racer1.setFullName("Sebastian Vettel");
        racer1.setTeam("FERRARI");
        racer1.setBestLapTime(64415L);

        Racer racer2 = new Racer();
        racer2.setRacerAbbreviation("NHR");
        racer2.setFullName("Nico Hulkenberg");
        racer2.setTeam("RENAULT");
        racer2.setBestLapTime(73065L);

        Racer racer3 = new Racer();
        racer3.setRacerAbbreviation("FAM");
        racer3.setFullName("Fernando Alonso");
        racer3.setTeam("MCLAREN RENAULT");
        racer3.setBestLapTime(72657L);

        racers.add(racer1);
        racers.add(racer2);
        racers.add(racer3);
        return racers;
    }
}