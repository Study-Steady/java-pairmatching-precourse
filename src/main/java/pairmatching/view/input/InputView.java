package pairmatching.view.input;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import pairmatching.model.crew.Course;
import pairmatching.view.output.Printer;

public class InputView {
    private static final Pattern detailInfoPattern = Pattern.compile("^[1-3,Q]$");
    private static final String backendCrewNamePath = "src/main/resources/backend-crew.md";
    private static final String frontendCrewNamePath = "src/main/resources/frontend-crew.md";

    private final Reader reader;
    private final Printer printer;
    private final FileReader fileReader;

    public InputView(Reader reader, Printer printer, FileReader fileReader) {
        this.reader = reader;
        this.printer = printer;
        this.fileReader = fileReader;
    }

    public List<String> readCrewNames(Course course) {
        if (course == Course.BACKEND) {
            return fileReader.readLineWithPath(backendCrewNamePath);
        }
        return fileReader.readLineWithPath(frontendCrewNamePath);
    }

    public String readDetailInfo() {
        String input = reader.readLine();
        validateInput(input);
        return input;
    }

    public int readCommand() {
        String input = reader.readLine();
        validateInput(input);
        validateCommand(input);
        if (input.equals("Q")) {
            return -1;
        }
        return Integer.parseInt(input);
    }

    private void validateInput(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCommand(String input) {
        if (!detailInfoPattern.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
