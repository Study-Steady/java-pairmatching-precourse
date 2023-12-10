package pairmatching.domain.course;

import java.util.Arrays;
import pairmatching.view.input.error.InputError;
import pairmatching.view.input.error.InputIllegalArgumentException;

public enum Course {

    FRONTEND("프론트엔드"),
    BACKEND("백엔드");

    final String name;

    Course(String name) {
        this.name = name;
    }

    public static Course getCourseByType(String inputValue) {
        return Arrays.stream(values())
                .filter(input -> input.name.equals(inputValue))
                .findFirst()
                .orElseThrow(() -> new InputIllegalArgumentException(InputError.NOT_POSSIBLE_INPUT));
    }
}
