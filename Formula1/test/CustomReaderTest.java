import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.interfaces.Readeble;
import ua.com.foxminded.util.reader.CustomReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class CustomReaderTest {
    Readeble reader;

    private List<String> expectedLines;

    @BeforeEach
    void setUp() throws IOException {
        expectedLines = Files.lines(Paths.get("test/filesfortests/end.log"))
                .collect(Collectors.toList());

        reader = new CustomReader();
    }

    @Test
    void readAndCollectLinesFomFile() {
        List<String> actualLines = reader.readAndCollectLinesFomFile("test/filesfortests/end.log");
        assertEquals(expectedLines, actualLines);
    }
}