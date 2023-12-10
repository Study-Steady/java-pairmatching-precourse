package pairmatching.controller;

import java.util.stream.Stream;

public enum RematchingChoice {

    YES("네"),
    NO("아니오");

    private final String name;

    RematchingChoice(String name) {
        this.name = name;
    }

    public static RematchingChoice getBy(String name) {
        return Stream.of(values())
                .filter(choice -> choice.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("No Matching Choice for name=%s", name)
                ));
    }

    public boolean isYes() {
        return this == YES;
    }

}
