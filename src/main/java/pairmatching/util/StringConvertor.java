package pairmatching.util;

public class StringConvertor {
    private static final String COMMA = ", ";

    private StringConvertor() {
    }

    public static String[] splitByComma(String input) {
        return input.split(COMMA);
    }
}
