package ua.com.foxminded;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<String> readAndCollectLinesFomFile(File file) {
        List<String> lines = new LinkedList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader);){
            String line = bufferedReader.readLine();
            while (line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
