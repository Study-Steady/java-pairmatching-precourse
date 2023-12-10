package pairmatching.view.input.error;

public enum InputError {

    INPUT_IS_BLANK("입력한 값이 빈 칸 입니다."),
    NOT_POSSIBLE_INPUT("입력할 수 없는 값입니다."),
    NOT_AVAILABLE_FILE_PATH("존재하지 않는 파일 경로입니다.");

    final String message;

    InputError(String message) {
        this.message = message;
    }
}
