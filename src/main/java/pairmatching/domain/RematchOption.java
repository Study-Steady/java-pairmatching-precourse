package pairmatching.domain;

import java.util.Arrays;

public enum RematchOption {
    REMATCH("네"), NOT_REMATCH("아니오");

    private final String userCommand;

    RematchOption(String userCommand) {
        this.userCommand = userCommand;
    }

    public static RematchOption from(String input) {
        return Arrays.stream(values())
                .filter(option -> option.userCommand.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("입력은 네, 아니오로 해야합니다."));
    }

    public boolean isRematch() {
        return this.equals(REMATCH);
    }
}
