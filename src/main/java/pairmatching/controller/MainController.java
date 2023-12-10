package pairmatching.controller;

import java.util.function.Supplier;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        FunctionChoice choice = inputChoice();
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
