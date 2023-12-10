package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pairs {
    private final List<Pair> pairs;

    public Pairs(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public static Pairs init() {
        return new Pairs(new ArrayList<>());
    }

    public void add(Pair pair) {
        pairs.add(pair);
    }

    public boolean containsSamePair(Pairs inputPairs) {
        return pairs.stream()
                .anyMatch(inputPairs::contains);
    }

    private boolean contains(Pair inputPair) {
        return pairs.stream()
                .anyMatch(pair -> pair.isSamePair(inputPair));
    }

    public List<Pair> getPairs() {
        return pairs;
    }
}
