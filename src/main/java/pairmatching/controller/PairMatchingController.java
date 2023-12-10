package pairmatching.controller;

import java.io.IOException;
import pairmatching.domain.Crews;
import pairmatching.domain.CrewsFactory;
import pairmatching.domain.LevelInfos;
import pairmatching.domain.PairMatcher;
import pairmatching.domain.Pairs;
import pairmatching.view.OutputView;
import pairmatching.view.handler.InputHandler;

public class PairMatchingController {
    private final InputHandler inputHandler;
    private final OutputView outputView;

    public PairMatchingController(InputHandler inputHandler, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void run() {
        String command = "";



        while (!command.equals("Q")) {
            outputView.printFunctionChoiceMessage();
            command = inputHandler.receiveValidatedFunctionCommand();
            outputView.printNewLine();
            startPairMatchingFunction(command);
            checkPairMatching(command);
            initPairMatching(command);

        }
    }

    private void startPairMatchingFunction(String command) {
        if (command.equals("1")) {
            outputView.printCourseAndMissionChoiceMessage(LevelInfos.getInstance());
            outputView.printNewLine();
            String options = inputHandler.receiveValidatedPairMatchingOptions();
            Crews crews = createCrews(options);
            PairMatcher pairMatcher = new PairMatcher(crews);
            Pairs pairs = pairMatcher.match();
            outputView.printMatchResult(pairs);
        }
    }

    private Crews createCrews(String options) {
        Crews crews = null;
        try {
            crews = CrewsFactory.createCrewsBy(options);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return crews;
    }

    private void checkPairMatching(String command) {
        if (command.equals("2")) {
            System.out.println("ddddd");
            outputView.printNewLine();
        }
    }

    private void initPairMatching(String command) {
        if (command.equals("3")) {
            outputView.printInitMesage();
            outputView.printNewLine();
        }
    }
}
