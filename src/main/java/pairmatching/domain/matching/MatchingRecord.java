package pairmatching.domain.matching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import pairmatching.domain.course.Course;
import pairmatching.domain.level.Level;
import pairmatching.domain.matching.dto.MatchingCrews;
import pairmatching.domain.mission.Mission;

public class MatchingRecord {

    private final Level level;
    private final Mission mission;
    private final Course course;
    private List<MatchingCrews> crewMatchingResult;

    public MatchingRecord(Level level, Mission mission, Course course, List<String> crewShuffleResult) {
        this.level = level;
        this.mission = mission;
        this.course = course;
        this.crewMatchingResult = matchingCrews(crewShuffleResult);
    }

    private List<MatchingCrews> matchingCrews(List<String> crewShuffleResult) {
        List<MatchingCrews> crewMatchingResult = new ArrayList<>();

        for (int i = 0; i < crewShuffleResult.size()-4; i += 2) {
            int endIndex = Math.min(i + 2, crewShuffleResult.size());
            List<String> matchedCrews = extractMatchedCrews(crewShuffleResult, i, endIndex);
            crewMatchingResult.add(new MatchingCrews(matchedCrews));
        }
        List<String> lastMatchedCrews = separateLastMatching(crewShuffleResult, crewMatchingResult);
        crewMatchingResult.add(new MatchingCrews(lastMatchedCrews));
        return crewMatchingResult;
    }

    private List<String> extractMatchedCrews(List<String> crewShuffleResult, int startIndex, int endIndex) {
        List<String> matchedCrews = new ArrayList<>(crewShuffleResult.subList(startIndex, endIndex));
        if (endIndex - startIndex == 1) {
            matchedCrews.add(crewShuffleResult.get(endIndex - 1));
        }
        return matchedCrews;
    }

    private List<String> separateLastMatching(List<String> crewShuffleResult, List<MatchingCrews> crewMatchingResult) {
        if (crewShuffleResult.size() % 2 == 1) {
            return crewShuffleResult.subList(crewShuffleResult.size() - 3, crewShuffleResult.size());
        }
        return crewShuffleResult.subList(crewShuffleResult.size() - 2, crewShuffleResult.size());
    }

    public List<MatchingCrews> getCrewMatchingResult() {
        return Collections.unmodifiableList(crewMatchingResult);
    }

    public void setCrewMatchingResult(MatchingRecord matchingRecord) {
        crewMatchingResult = matchingRecord.getCrewMatchingResult();
    }

    public boolean isEqualsMatchingRecordWithAll(Level newLevel, Mission newMission, Course newCourse) {
        return level.equals(newLevel) && mission.equals(newMission) && course.equals(newCourse);
    }

    public boolean isEqualsMatchingRecordWithLevel(Level newLevel, Course newCourse) {
        return level.equals(newLevel) && course.equals(newCourse);
    }

    public boolean isExistInRecordsFromNewCrewMatching(MatchingRecord matchingRecord) {
        return matchingRecord.crewMatchingResult.stream()
                .anyMatch(matchingCrews -> this.isExistCrewMatching(matchingCrews.matchedCrews()));
    }

    private boolean isExistCrewMatching(List<String> matchedCrews) {
        return crewMatchingResult.stream()
                .anyMatch(crews -> new HashSet<>(crews.matchedCrews()).containsAll(matchedCrews));
    }
}
