package pairmatching.controller;

import java.util.Optional;
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
        PairMatcher pairMatcher = new PairMatcher(crewRepository, pairMatchingHistoryRepository);

        FunctionChoice choice = inputChoice();

        while (!choice.isQuit()) {
            if (choice.isPairMatching()) {
                matchPair(pairMatcher);
            }
            if (choice.isQueryPair()) {
                queryHistory(inputPairMatchingRequest());
            }
            if (choice.isInitialization()) {
                initializeHistory();
            }
            choice = inputChoice();
        }

    }

    private void initializeHistory() {
        this.pairMatchingHistoryRepository.initialize();
    }

    private void matchPair(PairMatcher pairMatcher) {
        PairMatchingRequest request = inputPairMatchingRequest();

        while (pairMatchingHistoryRepository.exists(request)) {
            RematchingChoice choice = inputRematchingChoice();

            if (choice.isYes()) {
                pairMatchingHistoryRepository.delete(request);
                break;
            }

            request = input(inputView::inputPairMatchingRequestWithoutBoardGuide);
        }

        createNewPairMatching(pairMatcher, request);
    }

    private void createNewPairMatching(PairMatcher pairMatcher, PairMatchingRequest request) {
        PairMatchingHistory history = pairMatcher.match(request);
        outputView.showPairMatchingHistory(history);
    }

    private RematchingChoice inputRematchingChoice() {
        return input(() -> RematchingChoice.getBy(inputView.inputRematchingChoice()));
    }

    private void queryHistory(PairMatchingRequest request) {
        Optional<PairMatchingHistory> historyOptional = pairMatchingHistoryRepository.findOne(request);

        if (historyOptional.isPresent()) {
            outputView.showPairMatchingHistory(historyOptional.get());
            return;
        }
        outputView.showErrorMessage("매칭 이력이 없습니다.");
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
