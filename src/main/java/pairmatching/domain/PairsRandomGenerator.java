package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairsRandomGenerator implements PairsGenerator {
    private final List<String> backEndCrew;
    private final List<String> frontEndCrew;

    public PairsRandomGenerator() {
        List<String> backEndCrew = new ArrayList<>();
        List<String> frontEndCrew = new ArrayList<>();

        try {
            BufferedReader backEndReader = new BufferedReader(new FileReader("src/main/resources/backend-crew.md"));
            BufferedReader frontEndReader = new BufferedReader(new FileReader("src/main/resources/frontend-crew.md"));
            String crewName = "";
            while ((crewName = backEndReader.readLine()) != null) {
                backEndCrew.add(crewName);
            }
            while ((crewName = frontEndReader.readLine()) != null) {
                frontEndCrew.add(crewName);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.backEndCrew = backEndCrew;
        this.frontEndCrew = frontEndCrew;
    }

    @Override
    public Pairs generate(CurriculumDetail curriculumDetail) {
        Pairs pairs = Pairs.init();
        if (curriculumDetail.isBackEnd()) {
            pairs = generateBackendPairs(curriculumDetail, pairs);
        }
        if (!curriculumDetail.isBackEnd()) {
            pairs = generateFrontendPairs(curriculumDetail, pairs);
        }
        return pairs;
    }

    private Pairs generateFrontendPairs(CurriculumDetail curriculumDetail, Pairs pairs) {
        List<String> frontShuffled = Randoms.shuffle(frontEndCrew);
        for (int index = 0; index < frontShuffled.size(); index = index + 2) {
            if (isThreeCountPairCase(frontShuffled, index)) {
                Crew firstCrew = Crew.of(Course.FRONTEND, frontShuffled.get(index));
                Crew secondCrew = Crew.of(Course.FRONTEND, frontShuffled.get(index + 1));
                Crew thirdCrew = Crew.of(Course.FRONTEND, frontShuffled.get(index + 2));

                Pair pair = Pair.of(Arrays.asList(firstCrew, secondCrew, thirdCrew), curriculumDetail.getLevel());

                pairs.add(pair);
            }
            if (!isThreeCountPairCase(frontShuffled, index) ){
                Crew firstCrew = Crew.of(Course.FRONTEND, frontShuffled.get(index));
                Crew secondCrew = Crew.of(Course.FRONTEND, frontShuffled.get(index + 1));

                Pair pair = Pair.of(Arrays.asList(firstCrew, secondCrew), curriculumDetail.getLevel());

                pairs.add(pair);
            }
        }
        return pairs;
    }

    private Pairs generateBackendPairs(CurriculumDetail curriculumDetail, Pairs pairs) {
        List<String> backendShuffled = Randoms.shuffle(backEndCrew);
        for (int index = 0; index < backendShuffled.size(); index = index + 2) {
            if (isThreeCountPairCase(backendShuffled, index)) {
                Crew firstCrew = Crew.of(Course.BACKEND, backendShuffled.get(index));
                Crew secondCrew = Crew.of(Course.BACKEND, backendShuffled.get(index + 1));
                Crew thirdCrew = Crew.of(Course.BACKEND, backendShuffled.get(index + 2));

                Pair pair = Pair.of(Arrays.asList(firstCrew, secondCrew, thirdCrew), curriculumDetail.getLevel());

                pairs.add(pair);
            }
            if (!isThreeCountPairCase(backendShuffled, index) ){
                Crew firstCrew = Crew.of(Course.BACKEND, backendShuffled.get(index));
                Crew secondCrew = Crew.of(Course.BACKEND, backendShuffled.get(index + 1));

                Pair pair = Pair.of(Arrays.asList(firstCrew, secondCrew), curriculumDetail.getLevel());

                pairs.add(pair);
            }
        }
        return pairs;
    }

    private boolean isThreeCountPairCase(List<String> backendShuffled, int index) {
        return isOddSize(backendShuffled) && isLastPairOfOddSizeList(index, backendShuffled);
    }

    private static boolean isLastPairOfOddSizeList(int index, List<String> backendShuffled) {
        return index == backendShuffled.size() - 3;
    }

    private boolean isOddSize(List<String> backendShuffled) {
        return backendShuffled.size() % 2 != 0;
    }
}
