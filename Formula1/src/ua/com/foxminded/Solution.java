package ua.com.foxminded;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        File start = new File(Main.readLine());
//        List<String> startLog = Main.readAndCollectLinesFomFile(start);

//        File end = new File(Main.readLine());
//        List<String> endLog = Main.readAndCollectLinesFomFile(end);

        File abbreviations = new File(Main.readLine());
        List<String> abbreviationsList = Main.readAndCollectLinesFomFile(abbreviations);

        for (String s : abbreviationsList) {
            System.out.println(s);
        }
    }
}
