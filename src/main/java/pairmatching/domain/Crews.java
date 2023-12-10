package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Crews {
    private final List<Crew> crews;

    public Crews(List<Crew> crews) {
        this.crews = crews;
    }

    public List<Crew> getCrews() {
        return crews;
    }

    public List<String> getCrewNames() {
        return crews.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }
}
