package pairmatching.controller;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import pairmatching.model.crew.Course;
import pairmatching.model.crew.Crew;
import pairmatching.model.crew.Crews;
import pairmatching.model.pair.PairMatchChecker;
import pairmatching.model.pair.PairMatchHistories;
import pairmatching.view.input.InputView;
import pairmatching.view.output.OutputView;

public class PairMatchingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final PairMatchHistories histories;
    private PairMatchChecker checker;

    public PairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.histories = PairMatchHistories.create();
    }

    public void run() {
        Crews crews = getCrews();
        pairMatch(crews);
    }

    public Crews getCrews() {
        List<String> backendCrewNames = inputView.readCrewNames(Course.BACKEND);
        List<String> frontendCrewNames = inputView.readCrewNames(Course.FRONTEND);
        return Crews.of(
            backendCrewNames.stream()
                .map(name -> Crew.of(Course.BACKEND, name))
                .collect(Collectors.toList()),
            frontendCrewNames.stream()
                .map(name -> Crew.of(Course.FRONTEND, name))
                .collect(Collectors.toList()));
    }

    private void pairMatch(Crews crews) {
        this.checker = PairMatchChecker.from(crews);
        int command = inputView.readCommand();
    }

    private <T> T readRecursively (Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return readRecursively(supplier);
        }
    }
}
