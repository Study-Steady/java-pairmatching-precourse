package pairmatching.controller;

import java.util.stream.Stream;

public enum FunctionChoice {

    PAIR_MATCHING("1"),
    QUERY_PAIR("2"),
    INITIALIZATION("3"),
    QUIT("Q");

    private final String option;

    FunctionChoice(String option) {
        this.option = option;
    }

    public static FunctionChoice getBy(String option) {
        return Stream.of(FunctionChoice.values())
                .filter(functionChoice -> functionChoice.option.equals(option))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("No Matching Choice for option=%s", option)
                ));
    }

}
