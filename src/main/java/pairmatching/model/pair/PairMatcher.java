package pairmatching.model.pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pairmatching.model.crew.Course;
import pairmatching.model.crew.Level;

public class PairMatcher {
    private PairMatcher() {
    }

    public List<Pair> match(Course course, Level level, List<String> crewNames, PairMatchChecker history) {
        List<Pair> pairs = new ArrayList<>();
        if (crewNames.size() % 2 == 0) {
            while (!crewNames.isEmpty()) {
                String crew1Name = crewNames.remove(0);
                String crew2Name = crewNames.remove(0);
                if (history.isMatched(course, level, crew1Name, crew2Name)) {
                    throw new IllegalArgumentException();
                }
                pairs.add(Pair.from(Arrays.asList(crew1Name, crew2Name)));
            }
        }

        while (crewNames.size() > 3) {
            String crew1Name = crewNames.remove(0);
            String crew2Name = crewNames.remove(0);
            if (history.isMatched(course, level, crew1Name, crew2Name)) {
                throw new IllegalArgumentException();
            }
            pairs.add(Pair.from(Arrays.asList(crew1Name, crew2Name)));
        }

        String crew1Name = crewNames.remove(0);
        String crew2Name = crewNames.remove(0);
        String crew3Name = crewNames.remove(0);
        if (history.isMatched(course, level, crew1Name, crew2Name) || history.isMatched(course, level, crew1Name,
            crew3Name) || history.isMatched(course, level, crew2Name, crew3Name)) {
            throw new IllegalArgumentException();
        }
        pairs.add(Pair.from(Arrays.asList(crew1Name, crew2Name, crew3Name)));
        return pairs;
    }
}
