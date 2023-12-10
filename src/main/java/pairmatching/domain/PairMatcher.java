package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class PairMatcher {
    private static final int MAX_RETRY_COUNT = 3;
    private final Crews crews;

    public PairMatcher(Crews crews) {
        this.crews = crews;
    }

    public Pairs match() {
        List<String> crewNames = new ArrayList<>(crews.getCrewNames());
        List<String> shuffleCrewNames = Randoms.shuffle(crewNames);
        return new Pairs(createPairs(shuffleCrewNames));
//        int retryCount = 0;
//        while (retryCount < MAX_RETRY_COUNT) {
//            List<String> shuffleCrewNames = Randoms.shuffle(crewNames);
//            List<Pair> pairs = createPairs(shuffleCrewNames);
//            if (!hasPreviousPair(pairs)) {
//                return pairs;
//            }
//            retryCount++;
//        }
//        throw new IllegalStateException("매칭 3회 시도를 초과하였습니다.");
    }

    private List<Pair> createPairs(List<String> shuffleCrewNames) {
        List<Pair> pairs = new ArrayList<>();
        int size = shuffleCrewNames.size();
        for (int i = 0; i < size; i += 2) {
            Pair pair = new Pair();
            pair.addCrew(new Crew(shuffleCrewNames.get(i)));
            if (i + 1 < size) {
                pair.addCrew(new Crew(shuffleCrewNames.get(i + 1)));
            }
            pair.addPreviousPair();
            pairs.add(pair);
        }
        if (isOdd(size)) {
            Pair lastPair = pairs.get(pairs.size() - 2);
            lastPair.addCrew(new Crew(shuffleCrewNames.get(size - 1)));
            pairs.remove(pairs.size() - 1);
        }
        return pairs;
    }

    private boolean isOdd(int size) {
        return size % 2 != 0;
    }

    private boolean hasPreviousPair(List<Pair> pairs) {
        for (Pair pair : pairs) {
            if (pair.hasPreviousPair()) {
                return true;
            }
        }
        return false;
    }
}
