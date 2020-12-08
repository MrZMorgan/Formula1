import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import ua.com.foxminded.facade.RaceFacade;
import ua.com.foxminded.interfaces.Formatter;
import ua.com.foxminded.interfaces.Parser;
import ua.com.foxminded.interfaces.Reader;
import ua.com.foxminded.racer.Racer;
import ua.com.foxminded.util.parser.RacerParser;
import ua.com.foxminded.util.reader.RacerReader;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import static org.mockito.Mockito.*;

class RaceFacadeTest {

    private Formatter formatterMock;
    private Reader readerMock;
    private Parser parserMock;
    private RaceFacade facade;
    private final static String START_LOG_FILE_NAME = "test/filesfortests/start.log";
    private final static String END_LOG_FILE_NAME = "test/filesfortests/end.log";
    private final static String ABBREVIATIONS_FILE_NAME = "test/filesfortests/abbreviations.txt";
    private List<Racer> racers;
    private List<String> start;
    private List<String> end;
    private List<String> abbreviation;

    @BeforeEach
    void setUp() throws ParseException {
        formatterMock = mock(Formatter.class);
        readerMock = mock(RacerReader.class);
        parserMock = mock(RacerParser.class);
        facade = new RaceFacade(formatterMock, readerMock, parserMock);
        racers = createListOfRacersForTest();
        start = lineFromStartLog();
        end = linesFromEndLog();
        abbreviation = linesFromAbbreviationFile();

        when(readerMock.read(START_LOG_FILE_NAME)).thenReturn(start);
        when(readerMock.read(END_LOG_FILE_NAME)).thenReturn(end);
        when(readerMock.read(ABBREVIATIONS_FILE_NAME)).thenReturn(abbreviation);
        when(parserMock.parse(start, end, abbreviation)).thenReturn(racers);

        facade.printResultOfQualification(START_LOG_FILE_NAME, END_LOG_FILE_NAME, ABBREVIATIONS_FILE_NAME);
    }

    @Test
    void testNumbersOfInvocation() throws ParseException {
        verify(readerMock, times(1)).read(START_LOG_FILE_NAME);
        verify(readerMock, times(1)).read(END_LOG_FILE_NAME);
        verify(readerMock, times(1)).read(ABBREVIATIONS_FILE_NAME);
        verify(parserMock, times(1)).parse(start, end, abbreviation);
        verify(formatterMock, times(1)).format(racers);
    }

    @Test
    void orderInteractionTest() throws ParseException {
        InOrder inOrder = inOrder(formatterMock, parserMock, readerMock);

        inOrder.verify(readerMock).read(START_LOG_FILE_NAME);
        inOrder.verify(readerMock).read(END_LOG_FILE_NAME);
        inOrder.verify(readerMock).read(ABBREVIATIONS_FILE_NAME);
        inOrder.verify(parserMock).parse(start, end, abbreviation);
        inOrder.verify(formatterMock).format(racers);
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