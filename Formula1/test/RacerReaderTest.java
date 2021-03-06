import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.interfaces.Reader;
import ua.com.foxminded.util.reader.RacerReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class RacerReaderTest {

    private Reader reader;

    private List<String> expectedLines;

    @BeforeEach
    void setUp() throws IOException {
        expectedLines = Files.lines(Paths.get("test/filesfortests/end.log"))
                .collect(Collectors.toList());

        reader = new RacerReader();
    }

    @Test
    void readAndCollectLinesFomFile() {
        List<String> actualLines = reader.read("test/filesfortests/end.log");
        assertEquals(expectedLines, actualLines);
    }
}