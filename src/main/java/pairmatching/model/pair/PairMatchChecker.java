package pairmatching.model.pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import pairmatching.model.crew.Course;
import pairmatching.model.crew.Crews;
import pairmatching.model.crew.Level;

public class PairMatchChecker {
    private final Map<Level, Map<String, Set<String>>> backendHistory;
    private final Map<Level, Map<String, Set<String>>> frontendHistory;

    private PairMatchChecker(Map<Level, Map<String, Set<String>>> backendHistory, Map<Level, Map<String, Set<String>>> frontendHistory) {
        this.backendHistory = backendHistory;
        this.frontendHistory = frontendHistory;
    }

    public static PairMatchChecker from(Crews crews) {
        Map<Level, Map<String, Set<String>>> backendHistory = new HashMap<>();
        Map<Level, Map<String, Set<String>>> frontendHistory = new HashMap<>();

        for (Level level : Level.values()) {
            backendHistory.put(level, new HashMap<>());
            frontendHistory.put(level, new HashMap<>());

            for (String backendCrewName : crews.getCrewNames(Course.BACKEND)) {
                backendHistory.get(level).put(backendCrewName, new HashSet<>());
            }

            for (String frontendCrewName : crews.getCrewNames(Course.FRONTEND)) {
                frontendHistory.get(level).put(frontendCrewName, new HashSet<>());
            }
        }

        return new PairMatchChecker(backendHistory, frontendHistory);
    }

    public boolean isMatched(Course course, Level level, String crewName1, String crewName2) {
        if (course == Course.BACKEND) {
            return backendHistory.get(level).get(crewName1).contains(crewName2);
        }
        return frontendHistory.get(level).get(crewName1).contains(crewName2);
    }

    public void clear() {
        for (Level level : Level.values()) {
            for (String backendCrewName : backendHistory.get(level).keySet()) {
                backendHistory.get(level).get(backendCrewName).clear();
            }

            for (String frontendCrewName : frontendHistory.get(level).keySet()) {
                frontendHistory.get(level).get(frontendCrewName).clear();
            }
        }
    }
}
