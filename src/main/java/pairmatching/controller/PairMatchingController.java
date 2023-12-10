package pairmatching.controller;

import java.util.function.Supplier;
import pairmatching.domain.CurriculumDetail;
import pairmatching.domain.MainOption;
import pairmatching.domain.PairsGenerator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final PairsGenerator pairsGenerator;

    public PairMatchingController(InputView inputView, OutputView outputView, PairsGenerator pairsGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pairsGenerator = pairsGenerator;
    }

    public void run() {
        MainOption mainOption = inputView.inputMainOption();
        CurriculumDetail curriculumDetail = inputView.inputCurriculumDetail();
    }지

    private <T> T readWithRetry(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return readWithRetry(supplier);
        }
    }

    private <T, R> R readWithRetry(Function<T, R> function, T input) {
        try {
            return function.apply(input);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return readWithRetry(function, input);
        }
    }
}
