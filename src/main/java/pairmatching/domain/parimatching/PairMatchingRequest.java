package pairmatching.domain.parimatching;

import pairmatching.domain.Course;
import pairmatching.domain.Mission;

public class PairMatchingRequest {

    private final Course course;
    private final Mission mission;

    public PairMatchingRequest(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    public Mission getMission() {
        return mission;
    }

}
