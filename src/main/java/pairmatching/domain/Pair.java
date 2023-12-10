package pairmatching.domain;

import java.util.List;

public class Pair {

    private final List<Crew> crews;
    private final Level level;

    public Pair(List<Crew> crews, Level level) {
        this.crews = crews;
        this.level = level;
    }

    public static Pair of(List<Crew> crews, Level level) {
        return new Pair(crews, level);
    }

    public boolean isSamePair(Pair inputPair) {
        return crews.containsAll(inputPair.crews);
    }

    public List<Crew> getCrews() {
        return crews;
    }
}
