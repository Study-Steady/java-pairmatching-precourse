package pairmatching.domain.parimatching;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import pairmatching.domain.crew.Crew;

public class PairMatchingHistoryRepository {

    private final List<PairMatchingHistory> histories = new ArrayList<>();

    public PairMatchingHistoryRepository() {
    }

    public void save(PairMatchingHistory history) {
        this.histories.add(history);
    }

    public Optional<PairMatchingHistory> findOne(PairMatchingRequest request) {
        return this.histories.stream()
                .filter(history -> history.matches(request.getCourse(), request.getMission()))
                .findFirst();
    }

    public PairMatchingHistory getOne(PairMatchingRequest request) {
        return findOne(request).orElseThrow(() -> new IllegalArgumentException("No History exist"));
    }

    public boolean exists(PairMatchingRequest request) {
        return this.histories.stream()
                .anyMatch(history -> history.matches(request.getCourse(), request.getMission()));
    }

    public void initialize() {
        clearCrewMetHistory();
        this.histories.clear();
    }

    private void clearCrewMetHistory() {
        this.histories.stream()
                .flatMap(history -> history.getPairs().stream())
                .flatMap(pair -> pair.getCrews().stream())
                .forEach(Crew::clearMetHistory);
    }

    public void delete(PairMatchingRequest request) {
        this.histories.remove(getOne(request));
    }

}
