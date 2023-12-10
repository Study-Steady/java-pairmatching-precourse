package pairmatching.view.handler;

import java.util.function.Supplier;
import pairmatching.view.ErrorView;
import pairmatching.view.InputView;

public class InputHandler {
    private final InputView inputView;
    private final ErrorView errorView;

    public InputHandler(InputView inputView, ErrorView errorView) {
        this.inputView = inputView;
        this.errorView = errorView;
    }

    public String receiveValidatedFunctionCommand() {
        return receiveValidatedInput(inputView::inputFunctionCommand);
    }

    public String receiveValidatedPairMatchingOptions() {
        return receiveValidatedInput(inputView::inputPairMatchingOptions);
    }

    public String receiveValidatedRetryMatching() {
        return receiveValidatedInput(inputView::inputRetryMatching);
    }

    private <T> T receiveValidatedInput(Supplier<T> inputView) {
        while (true) {
            try {
                return inputView.get();
            } catch (IllegalArgumentException exception) {
                errorView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
