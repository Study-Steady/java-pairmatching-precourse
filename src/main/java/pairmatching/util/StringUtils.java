package pairmatching.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    public static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(",")).collect(Collectors.toList());
    }
}
