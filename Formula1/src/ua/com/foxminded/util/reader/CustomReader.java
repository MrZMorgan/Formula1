package ua.com.foxminded.util.reader;

import ua.com.foxminded.interfaces.Readeble;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomReader implements Readeble {

    public List<String> readAndCollectLinesFomFile(String filename) {
        List<String> strings = new LinkedList<>();

        try {
            strings = Files.lines(Paths.get(filename)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strings;
    }
}