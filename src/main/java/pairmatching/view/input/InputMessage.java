package pairmatching.view.input;

public enum InputMessage {
    SELECT_FUNCTION("기능을 선택하세요."),
    ALREADY_MATCHED("매칭 정보가 있습니다. 다시 매칭하시겠습니까?" + System.lineSeparator() + "예 | 아니오"),
    ;

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
