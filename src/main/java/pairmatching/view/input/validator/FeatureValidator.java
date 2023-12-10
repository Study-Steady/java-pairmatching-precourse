package pairmatching.view.input.validator;

import java.util.List;
import pairmatching.view.input.error.InputError;
import pairmatching.view.input.error.InputIllegalArgumentException;

public class FeatureValidator {

    private static final List<String> FEATURES = List.of("1", "2", "3", "Q");

    public FeatureValidator() {
    }

    public String validate(String inputValue) {
        validateNotBlank(inputValue);
        isExistFeature(inputValue);
        return inputValue;
    }

    private void validateNotBlank(String inputValue) {
        if (inputValue.isBlank()) {
            throw new InputIllegalArgumentException(InputError.INPUT_IS_BLANK);
        }
    }

    private void isExistFeature(String inputValue) {
        if (!FEATURES.contains(inputValue)) {
            throw new InputIllegalArgumentException(InputError.NOT_POSSIBLE_INPUT);
        }
    }
}
