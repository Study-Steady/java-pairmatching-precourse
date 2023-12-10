package pairmatching.domain.crew;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import pairmatching.util.RandomShuffler;

public class RandomCrewShuffler implements RandomShuffler {

    @Override
    public List<String> shuffleList(List<String> crews) {
        return Randoms.shuffle(crews);
    }
}
