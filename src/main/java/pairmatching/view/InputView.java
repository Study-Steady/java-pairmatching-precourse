package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.validator.FunctionCommandValidator;

public class InputView {

    public String inputFunctionCommand() {
        String command = Console.readLine();
        FunctionCommandValidator.validate(command);
        return command;
    }
}
