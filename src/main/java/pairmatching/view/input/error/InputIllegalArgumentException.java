package pairmatching.view.input.error;

public class InputIllegalArgumentException extends IllegalArgumentException {

    private static final String ERROR_SYMBOL = "[ERROR]";

    public InputIllegalArgumentException(InputError inputError) {
        super(ERROR_SYMBOL + inputError.message);
    }

}