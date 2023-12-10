package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.view.input.InputView;
import pairmatching.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        new PairMatchingController(inputView, outputView).run();
    }
}
