package pairmatching.view.input.validator;

import java.util.List;
import pairmatching.view.input.error.InputError;
import pairmatching.view.input.error.InputIllegalArgumentException;

public class ReMatchingValidator {

    private static final List<String> RESTART_OR_NOT = List.of("네", "아니오");

    public String validate(String input) {
        validateNotBlank(input);
        validateRestartOrNotFormat(input);
        return input;
    }

    private void validateNotBlank(String inputValue) {
        if (inputValue.isBlank()) {
            throw new InputIllegalArgumentException(InputError.INPUT_IS_BLANK);
        }
    }

    private void validateRestartOrNotFormat(String inputValue) {
        if (!RESTART_OR_NOT.contains(inputValue)) {
            throw new InputIllegalArgumentException(InputError.NOT_POSSIBLE_INPUT);
        }
    }
}
