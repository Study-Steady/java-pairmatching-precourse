package pairmatching.domain;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static boolean contains(String name) {
        return EnumSet.allOf(Course.class).stream()
                .anyMatch(course -> course.name.equals(name));
    }

    public static List<String> getNames() {
        return EnumSet.allOf(Course.class).stream()
                .map(course -> course.name)
                .collect(Collectors.toList());
    }
}
