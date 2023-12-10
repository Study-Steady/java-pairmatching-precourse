package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.view.ErrorView;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import pairmatching.view.handler.InputHandler;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ErrorView errorView = new ErrorView();
        InputHandler inputHandler = new InputHandler(inputView, errorView);
        OutputView outputView = new OutputView();
        PairMatchingController controller = new PairMatchingController(inputHandler, outputView);
        controller.run();
    }
}
