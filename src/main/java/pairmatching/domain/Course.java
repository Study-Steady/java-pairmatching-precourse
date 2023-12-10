package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course from(String input) {
        return Arrays.stream(values())
                .filter(course -> course.name.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("입력은 백엔드, 프론트엔드 중에서 해야합니다."));
    }

    public boolean isBackEnd() {
        return this.equals(BACKEND);
    }
}
