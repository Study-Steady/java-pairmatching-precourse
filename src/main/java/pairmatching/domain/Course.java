package pairmatching.domain;

import java.util.stream.Stream;

public enum Course {

    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course getBy(String name) {
        return Stream.of(Course.values())
                .filter(course -> course.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("No Matching Course for name=%s", name)
                ));
    }

    public boolean is(Course course) {
        return this == course;
    }

}