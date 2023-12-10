package pairmatching.domain.parimatching;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class PairMatchingRequest {

    private final Course course;
    private final Mission mission;

    private PairMatchingRequest(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public static PairMatchingRequest of(Course course, Level level, Mission mission) {
        if (!isValidMission(level, mission)) {
            throw new IllegalArgumentException("Mission Or Level choice is invalid.");
        }
        return new PairMatchingRequest(course, mission);
    }

    private static boolean isValidMission(Level level, Mission mission) {
        return mission.matchesLevel(level);
    }

    public Course getCourse() {
        return course;
    }

    public Mission getMission() {
        return mission;
    }

}
