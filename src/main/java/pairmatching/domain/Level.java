package pairmatching.domain;

import java.util.stream.Stream;

public enum Level {

    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Level(String name) {
        this.name = name;
    }

    public static Level getBy(String name) {
        return Stream.of(Level.values())
                .filter(level -> level.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("No Matching Level for name=%s", name)
                ));
    }

}
