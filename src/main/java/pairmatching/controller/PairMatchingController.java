package pairmatching.controller;

import java.util.function.Supplier;
import pairmatching.domain.CurriculumDetail;
import pairmatching.domain.MainOption;
import pairmatching.domain.PairsGenerator;
import pairmatching.domain.PairsStorage;
import pairmatching.domain.RematchOption;
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
        MainOption mainOption = MainOption.DEFAULT;
        PairsStorage pairsStorage = PairsStorage.init();

        while (!mainOption.isQuit(mainOption)) {
            mainOption = readWithRetry(inputView::inputMainOption);

            handlePairMatching(mainOption, pairsStorage);
            handlePairSearching(mainOption, pairsStorage);
            handlePairInit(mainOption, pairsStorage);
        }

    }

    private void handlePairInit(MainOption mainOption, PairsStorage pairsStorage) {
        if (mainOption.isFairInit()) {
            pairsStorage.initialize();
        }
    }

    private void handlePairSearching(MainOption mainOption, PairsStorage pairsStorage) {
        if (mainOption.isFairSearching()) {
            CurriculumDetail curriculumDetail = readWithRetry(inputView::inputCurriculumDetail);

            if (pairsStorage.containsOf(curriculumDetail)) {
                outputView.printPairsMatching(pairsStorage, curriculumDetail);
            }

            if (!pairsStorage.containsOf(curriculumDetail)) {
                outputView.printNoRecord();
            }
        }
    }

    private void handlePairMatching(MainOption mainOption, PairsStorage pairsStorage) {
        if (mainOption.isFairMatching()) {
            CurriculumDetail curriculumDetail = readWithRetry(inputView::inputCurriculumDetail);

            if (pairsStorage.containsOf(curriculumDetail)) {
                RematchOption rematchOption = readWithRetry(inputView::inputRematchOption);

                if (!rematchOption.isRematch()) {
                    return;
                }
            }
            pairsStorage.addMathcingsOf(curriculumDetail, pairsGenerator);
            outputView.printPairsMatching(pairsStorage, curriculumDetail);
        }
    }

    private <T> T readWithRetry(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return readWithRetry(supplier);
        }
    }
}
