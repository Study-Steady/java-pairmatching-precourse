package pairmatching.domain;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;

    Level(String name) {
        this.name = name;
    }

    public static boolean contains(String name) {
        return EnumSet.allOf(Level.class).stream()
                .anyMatch(level -> level.name.equals(name));
    }

    public static List<Level> getLevels() {
        return new ArrayList<>(EnumSet.allOf(Level.class));
    }

    public static Level getByName(String name) {
        return EnumSet.allOf(Level.class).stream()
                .filter(level -> level.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 레벨입니다."));
    }

    public String getName() {
        return name;
    }
}
