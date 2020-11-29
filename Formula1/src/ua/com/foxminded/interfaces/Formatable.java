package ua.com.foxminded.interfaces;

import ua.com.foxminded.racer.Racer;

import java.util.List;

public interface Formatable {
    String formatResultLine(Racer racer,
                            int racerPosition,
                            int maxLengthOfRacerPosition,
                            int maxLengthOfFullName,
                            int maxLengthOfTeamName);

    List<String> formatRacerResultList(List<Racer> racers);
}
