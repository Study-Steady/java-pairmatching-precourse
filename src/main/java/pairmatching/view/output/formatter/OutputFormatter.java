package pairmatching.view.output.formatter;

import java.util.List;

public class OutputFormatter {

    public static String joinValue(List<String> inputValue) {
        return String.join(" : ", inputValue);
    }
}
