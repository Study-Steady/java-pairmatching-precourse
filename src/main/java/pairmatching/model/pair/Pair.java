package pairmatching.model.pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pair {
    private final Set<String> crews;

    private Pair(Set<String> crews) {
        this.crews = crews;
    }

    public static Pair from(List<String> crews) {
        return new Pair(new HashSet<>(crews));
    }

    public List<String> getPairCrewNames() {
        return new ArrayList<>(crews);
    }
}
