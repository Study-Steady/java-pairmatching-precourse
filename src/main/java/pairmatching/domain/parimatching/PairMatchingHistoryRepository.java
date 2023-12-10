package pairmatching.domain.parimatching;

import java.util.ArrayList;
import java.util.List;

public class PairMatchingHistoryRepository {

    private final List<PairMatchingHistory> histories = new ArrayList<>();

    public PairMatchingHistoryRepository() {
    }

    public void save(PairMatchingHistory history) {
        this.histories.add(history);
    }

}
