package pairmatching.view;

import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.LevelInfos;
import pairmatching.domain.Pairs;

public class OutputView {
    private static final String LEVEL_PREFIX = "  - ";
    private static final String DIVIDE_LINE = "#############################################";

    public void printFunctionChoiceMessage() {
        System.out.println("기능을 선택하세요");
        printlnFunctionFormat("1", "페어 매칭");
        printlnFunctionFormat("2", "페어 조회");
        printlnFunctionFormat("3", "페어 초기화");
        printlnFunctionFormat("Q", "종료");
    }

    private void printlnFunctionFormat(String command, String message) {
        System.out.printf("%s. %s\n", command, message);
    }

    public void printCourseAndMissionChoiceMessage(LevelInfos levelInfos) {
        printDividingLine();
        System.out.printf("과정: %s\n", String.join(" | ", Course.getNames()));
        System.out.println("미션:");
        for (Level level : Level.getLevels()) {
            System.out.printf(LEVEL_PREFIX + "%s: %s\n", level.getName(),
                    String.join(" | ", levelInfos.getMissionNamesOfLevel(level)));
        }
        printDividingLine();
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
    }

    public void printMatchResult(Pairs pairs) {
        System.out.println("페어 매칭 결과입니다.");
        StringBuilder results = new StringBuilder();
        for (List<String> names : pairs.getPairNames()) {
            results.append(String.format("%s : %s\n", names.get(0), names.get(1)));
        }
        System.out.println(results);
    }

    private void printDividingLine() {
        System.out.println(DIVIDE_LINE);
    }

    public void printInitMesage() {
        System.out.println("초기화 되었습니다.");
    }

    public void printNoMatchingHistoryMessage() {
        System.out.println("[ERROR] 매칭 이력이 없습니다.");
    }

    public void printNewLine() {
        System.out.println();
    }
}
