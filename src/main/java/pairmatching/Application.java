package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.domain.PairsGenerator;
import pairmatching.domain.PairsRandomGenerator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import pairmatching.view.printer.ConsolePrinter;
import pairmatching.view.printer.Printer;
import pairmatching.view.reader.ConsoleReader;
import pairmatching.view.reader.Reader;

public class Application {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Printer printer = new ConsolePrinter();

        InputView inputView = InputView.of(reader, printer);
        OutputView outputView = new OutputView(printer);

        PairsGenerator pairsGenerator = new PairsRandomGenerator();
        PairMatchingController pairMatchingController = new PairMatchingController(inputView, outputView, pairsGenerator);
        pairMatchingController.run();
    }
}
