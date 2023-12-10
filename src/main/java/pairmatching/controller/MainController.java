package pairmatching.controller;

import java.util.function.Supplier;
import pairmatching.domain.crew.CrewRepository;
import pairmatching.domain.parimatching.PairMatcher;
import pairmatching.domain.parimatching.PairMatchingHistory;
import pairmatching.domain.parimatching.PairMatchingHistoryRepository;
import pairmatching.domain.parimatching.PairMatchingRequest;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CrewRepository crewRepository;
    private final PairMatchingHistoryRepository pairMatchingHistoryRepository;

    private MainController(
            InputView inputView,
            OutputView outputView,
            CrewRepository crewRepository,
            PairMatchingHistoryRepository pairMatchingHistoryRepository
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.crewRepository = crewRepository;
        this.pairMatchingHistoryRepository = pairMatchingHistoryRepository;
    }

    public static MainController of(InputView inputView, OutputView outputView) {
        return new MainController(
                inputView,
                outputView,
                CrewRepository.initialize(),
                new PairMatchingHistoryRepository()
        );
    }

    public void run() {
        FunctionChoice choice = inputChoice();
        PairMatcher pairMatcher = new PairMatcher(crewRepository, pairMatchingHistoryRepository);

        if (choice.isPairMatching()) {
            PairMatchingRequest request = inputPairMatchingRequest();
            PairMatchingHistory history = pairMatcher.match(request);
            outputView.showPairMatchingHistory(history);
        }
    }

    private PairMatchingRequest inputPairMatchingRequest() {
        return input(() -> inputView.inputPairMatchingRequest());
    }

    private FunctionChoice inputChoice() {
        return input(() -> FunctionChoice.getBy(inputView.inputChoice()));
    }

    private <T> T input(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e.getMessage());
            return input(supplier);
        }
    }

}
