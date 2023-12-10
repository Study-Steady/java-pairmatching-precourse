package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pair {
    private List<Crew> pair = new ArrayList<>();

    public void addCrew(Crew crew) {
        pair.add(crew);
    }

    public boolean contains(Crew crew) {
        return pair.contains(crew);
    }

    public void addPreviousPair() {
        pair.forEach(crew -> {
            pair.stream()
                    .filter(other -> !crew.equals(other))
                    .forEach(other -> crew.addPreviousPair(other.getName()));
        });
    }

    public boolean hasPreviousPair() {
        return pair.stream()
                .anyMatch(crew -> pair.stream()
                        .filter(other -> !crew.equals(other))
                        .anyMatch(other -> crew.alreadyPaired(other.getName())));
    }

    public List<String> getPairNames() {
        return pair.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Pair{" +
                "pair=" + pair +
                '}';
    }
}
