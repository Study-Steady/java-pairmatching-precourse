package pairmatching.view.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringConvertor {

    private StringConvertor() {
    }

    public static List<String> split(String source, String delimiter) {
        String whiteSpaceRemoved = source.replaceAll(" ", "");
        return Arrays.asList(whiteSpaceRemoved.split(delimiter));
    }

}
