package pairmatching.view.utils;

import java.util.Objects;

public class StringValidator {

    public static void validateHasText(String source) {
        if (!hasText(source)) {
            throw new IllegalArgumentException(String.format("String '%s' doesn't have text.", source));
        }
    }

    private static boolean hasText(String source) {
        return Objects.nonNull(source) && !source.isEmpty();
    }

}
