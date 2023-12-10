package pairmatching.domain.parimatching;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Mission;
import pairmatching.domain.crew.Crew;

public class Pair {

    private final List<Crew> crews;

    public Pair(List<Crew> crews) {
        this.crews = crews;
    }

    public static Pair of(Crew... crews) {
        return new Pair(Arrays.asList(crews));
    }

    public List<Crew> getCrews() {
        return crews;
    }

    public boolean hasMet(Mission mission) {
        return this.crews.stream()
                .anyMatch(crew -> crew.hasMet(mission, fetchCrewListExcept(crew)));
    }

    public void addMetHistory(Mission mission) {
        this.crews.forEach(crew -> crew.addMetHistory(mission, fetchCrewListExcept(crew)));
    }

    private List<Crew> fetchCrewListExcept(Crew target) {
        return this.crews.stream()
                .filter(crew -> !crew.equals(target))
                .collect(Collectors.toList());
    }

}
