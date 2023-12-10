package pairmatching.domain.parimatching;

import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Mission;

public class PairMatchingHistory {

    private final Course course;
    private final Mission mission;
    private final List<Pair> pairs;

    public PairMatchingHistory(Course course, Mission mission, List<Pair> pairs) {
        this.course = course;
        this.mission = mission;
        this.pairs = pairs;
    }

    public boolean matches(Course course, Mission mission) {
        return this.course == course && this.mission == mission;
    }

    public List<Pair> getPairs() {
        return pairs;
    }

}
