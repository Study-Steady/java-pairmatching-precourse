package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PairsRandomGenerator implements PairsGenerator {
    private final List<String> backEndCrew;
    private final List<String> frontEndCrew;

    public PairsRandomGenerator() {
        this.backEndCrew = readCrewFromFile("src/main/resources/backend-crew.md");
        this.frontEndCrew = readCrewFromFile("src/main/resources/frontend-crew.md");
    }

    private List<String> readCrewFromFile(String filePath) {
        List<String> crewList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String crewName;
            while ((crewName = reader.readLine()) != null) {
                crewList.add(crewName);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return crewList;
    }

    @Override
    public Pairs generate(CurriculumDetail curriculumDetail) {
        Pairs pairs = Pairs.init();
        List<String> selectedCrew = new ArrayList<>();
        if (curriculumDetail.isBackEnd()) {
            selectedCrew = backEndCrew;
        }
        if (!curriculumDetail.isBackEnd()) {
            selectedCrew = frontEndCrew;
        }
        generatePairs(curriculumDetail, pairs, selectedCrew);
        return pairs;
    }

    private void generatePairs(CurriculumDetail curriculumDetail, Pairs pairs, List<String> selectedCrew) {
        List<String> shuffledCrew = Randoms.shuffle(selectedCrew);
        for (int index = 0; index < shuffledCrew.size(); index += 2) {
            if (isThreeCountPairCase(shuffledCrew, index)) {
                addThreeCountPair(curriculumDetail, pairs, shuffledCrew, index);
                break;
            }
            addTwoCountPair(curriculumDetail, pairs, shuffledCrew, index);
        }
    }

    private void addThreeCountPair(CurriculumDetail curriculumDetail, Pairs pairs, List<String> shuffledCrew, int index) {
        List<Crew> crewList = createCrewList(curriculumDetail.getCourse(), shuffledCrew.get(index), shuffledCrew.get(index + 1), shuffledCrew.get(index + 2));
        pairs.add(Pair.of(crewList, curriculumDetail.getLevel()));
    }

    private void addTwoCountPair(CurriculumDetail curriculumDetail, Pairs pairs, List<String> shuffledCrew, int index) {
        List<Crew> crewList = createCrewList(curriculumDetail.getCourse(), shuffledCrew.get(index), shuffledCrew.get(index + 1));
        pairs.add(Pair.of(crewList, curriculumDetail.getLevel()));
    }

    private List<Crew> createCrewList(Course course, String... crewNames) {
        List<Crew> crewList = new ArrayList<>();
        for (String crewName : crewNames) {
            crewList.add(Crew.of(course, crewName));
        }
        return crewList;
    }

    private boolean isThreeCountPairCase(List<String> backendShuffled, int index) {
        return isOddSize(backendShuffled) && isLastPairOfOddSizeList(index, backendShuffled);
    }

    private static boolean isLastPairOfOddSizeList(int index, List<String> backendShuffled) {
        return index == backendShuffled.size() - 3;
    }

    private boolean isOddSize(List<String> shuffledList) {
        return shuffledList.size() % 2 != 0;
    }
}
