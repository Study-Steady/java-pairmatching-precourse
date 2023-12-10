package pairmatching.model.pair;

import java.util.List;
import pairmatching.model.crew.Course;
import pairmatching.model.crew.Level;
import pairmatching.model.crew.Mission;

public class PairMatchHistory {
    private final Course course;
    private final Level level;
    private final Mission mission;
    private final Pair pair;

    private PairMatchHistory(Course course, Level level, Mission mission, Pair pair) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.pair = pair;
    }

    public static PairMatchHistory of(Course course, Level level, Mission mission, Pair pair) {
        return new PairMatchHistory(course, level, mission, pair);
    }

    public boolean checkInfoMatches(Course course, Level level, Mission mission) {
        return this.course == course && this.level == level && this.mission == mission;
    }

    public List<String> getCrewNames() {
        return pair.getPairCrewNames();

    }
}
