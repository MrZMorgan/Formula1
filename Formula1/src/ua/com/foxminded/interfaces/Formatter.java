package ua.com.foxminded.interfaces;

import ua.com.foxminded.racer.Racer;

import java.util.List;

public interface Formatter {

    String format(Racer racer,
                  int racerPosition,
                  int maxLengthOfRacerPosition,
                  int maxLengthOfFullName,
                  int maxLengthOfTeamName);

    List<String> format(List<Racer> racers);
}
