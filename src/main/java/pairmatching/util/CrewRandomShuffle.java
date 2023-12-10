package pairmatching.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CrewRandomShuffle implements RandomShuffle {
    @Override
    public List<String> shuffle(List<String> input) {
        return Randoms.shuffle(input);
    }
}
