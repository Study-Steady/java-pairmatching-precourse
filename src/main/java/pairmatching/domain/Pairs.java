package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Pairs {
    private final List<Pair> pairs;

    public Pairs(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public List<List<String>> getPairNames() {
        return pairs.stream()
                .map(Pair::getPairNames)
                .collect(Collectors.toList());
    }
}
