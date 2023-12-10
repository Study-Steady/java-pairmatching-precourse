package pairmatching.model.pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import pairmatching.model.crew.Course;
import pairmatching.model.crew.Level;
import pairmatching.model.crew.Mission;

public class PairMatchHistories {
    private final Set<PairMatchHistory> pairMatchHistories;

    private PairMatchHistories(Set<PairMatchHistory> pairMatchHistories) {
        this.pairMatchHistories = pairMatchHistories;
    }

    public static PairMatchHistories create() {
        return new PairMatchHistories(new HashSet<>());
    }

    public List<String> find(Course course, Level level, Mission mission) {
        List<String> names = new ArrayList<>();

        for (PairMatchHistory history: pairMatchHistories) {
            if (history.checkInfoMatches(course, level, mission)) {
                names.add(String.join(",", history.getCrewNames()));
            }
        }

        return names;
    }

    public void add(PairMatchHistory pairMatchHistory) {
        pairMatchHistories.add(pairMatchHistory);
    }

    public void clear() {
        pairMatchHistories.clear();
    }
}
