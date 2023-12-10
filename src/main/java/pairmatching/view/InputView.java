package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.validator.FunctionCommandValidator;
import pairmatching.view.validator.MatchingOptionValidator;

public class InputView {

    public String inputFunctionCommand() {
        String command = Console.readLine();
        FunctionCommandValidator.validate(command);
        return command;
    }

    public String inputPairMatchingOptions() {
        String input = Console.readLine();
        MatchingOptionValidator.validate(input);
        return input;
    }
}
