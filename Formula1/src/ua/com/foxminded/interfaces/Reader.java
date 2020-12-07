package ua.com.foxminded.interfaces;

import java.util.List;

public interface Reader {
    List<String> readAndCollectLinesFomFile(String filename);
}
