import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.util.CustomReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CustomReaderTest {
    private List<String> expectedLines;

    @BeforeEach
    void setUp() throws IOException {
        expectedLines = Files.lines(Paths.get("test/filesfortests/end.log"))
                .collect(Collectors.toList());
    }

    @Test
    void readAndCollectLinesFomFile() {
        List<String> actualLines = CustomReader.readAndCollectLinesFomFile("test/filesfortests/end.log");
        assertEquals(expectedLines, actualLines);
    }
}