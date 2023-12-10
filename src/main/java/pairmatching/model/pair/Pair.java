package pairmatching.model.pair;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import pairmatching.model.crew.Crew;

public class Pair {
    private final Set<Crew> crews;

    private Pair(Set<Crew> crews) {
        this.crews = crews;
    }

    public static Pair from(List<Crew> crews) {
        return new Pair(Set.copyOf(crews));
    }

    public List<String> getPairCrewNames() {
        return crews.stream()
            .map(Crew::getName)
            .collect(Collectors.toList());
    }
}
