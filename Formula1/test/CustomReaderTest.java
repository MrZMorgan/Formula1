import org.junit.jupiter.api.Test;
import ua.com.foxminded.util.CustomReader;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomReaderTest {


    @Test
    void readAndCollectLinesFomFile() {
        List<String> expectedLines = new LinkedList<>();
        expectedLines.add("MES2018-05-24_12:05:58.778");
        expectedLines.add("RGH2018-05-24_12:06:27.441");
        expectedLines.add("SPF2018-05-24_12:13:13.883");

        List<String> actualLines = CustomReader.readAndCollectLinesFomFile("test/test.txt");

        assertEquals(expectedLines, actualLines);
    }
}