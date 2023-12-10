package pairmatching.domain.matching.dto;

import pairmatching.domain.course.Course;
import pairmatching.domain.level.Level;
import pairmatching.domain.mission.Mission;

public record MatchingSelection(Course courseType, Level level, Mission mission) {
}
