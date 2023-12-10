package pairmatching.view.validator;

public class FunctionCommandValidator {

    private FunctionCommandValidator() {
    }

    public static void validate(String command) {
        validateCommand(command);
        validateBlank(command);
    }

    private static void validateCommand(String command) {
        if (!(command.equals("1") || command.equals("2") || command.equals("3") || command.equals("Q"))) {
            throw new IllegalArgumentException("1,2,3,Q 문자만 입력할 수 있습니다.");
        }
    }

    private static void validateBlank(String command) {
        if (command.isEmpty() || command.equals(" ")) {
            throw new IllegalArgumentException("아무런 값을 입력하지 않았습니다.");
        }
    }
}
