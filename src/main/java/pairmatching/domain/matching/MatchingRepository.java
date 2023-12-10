package pairmatching.domain.matching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pairmatching.domain.matching.dto.MatchingSelection;

public class MatchingRepository {

    private static final List<MatchingRecord> matchingRecords = new ArrayList<>();

    public static List<MatchingRecord> matching() {
        return Collections.unmodifiableList(matchingRecords);
    }

    private MatchingRepository(){

    }

    public static void initMatching() {
        matchingRecords.clear();
    }

    public static void addMatchingRecord(MatchingRecord matchingRecord) {
        matchingRecords.add(matchingRecord);
    }

    public static void setMatchingRecord(MatchingRecord matchingRecord, MatchingRecord newMatchingRecord) {
        matchingRecord.setCrewMatchingResult(newMatchingRecord);
    }

    public static boolean isExistSameMissionMatching(MatchingSelection matchingSelection) {
        return findMatchingRecordsByLevelAndMission(matchingSelection) != null;
    }

    public static boolean isExistCrewMatching(MatchingSelection matchingSelection, MatchingRecord matchingRecord) {
        List<MatchingRecord> matchingRecords = findMatchingRecordsByLevelAndCourse(matchingSelection);

        return matchingRecords.stream()
                .anyMatch(matchingRecord1 -> matchingRecord1.isExistInRecordsFromNewCrewMatching(matchingRecord));
    }

    public static MatchingRecord findMatchingRecordsByLevelAndMission(MatchingSelection matchingSelection) {
        return matchingRecords.stream()
                .filter(record -> record.isEqualsMatchingRecordWithAll(matchingSelection.level(),
                        matchingSelection.mission(), matchingSelection.courseType()))
                .findFirst()
                .orElse(null);
    }

    private static List<MatchingRecord> findMatchingRecordsByLevelAndCourse(MatchingSelection matchingSelection) {
        return matchingRecords.stream()
                .filter(record -> record.isEqualsMatchingRecordWithLevel(matchingSelection.level(),
                        matchingSelection.courseType()))
                .filter(record -> !record.isEqualsMatchingRecordWithAll(matchingSelection.level(),
                        matchingSelection.mission(), matchingSelection.courseType()))
                .toList();
    }
}
