package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.parimatching.PairMatchingRequest;
import pairmatching.view.utils.StringConvertor;
import pairmatching.view.utils.StringValidator;

public class InputView {

    public String inputChoice() {
        println("기능을 선택하세요.\n"
                + "1. 페어 매칭\n"
                + "2. 페어 조회\n"
                + "3. 페어 초기화\n"
                + "Q. 종료");

        String input = readLine();
        StringValidator.validateHasText(input);
        return input;
    }

    public PairMatchingRequest inputPairMatchingRequest() {
        printCourseMissionInputGuide();

        String input = readLine();
        validate(input);
        List<String> split = StringConvertor.split(input, ",");

        String course = split.get(0);
        String level = split.get(1);
        String mission = split.get(2);

        return PairMatchingRequest.of(Course.getBy(course), Level.getBy(level), Mission.getBy(mission));
    }

    private void validate(String input) {
        StringValidator.validateHasText(input);

        List<String> split = StringConvertor.split(input, ",");
        if (split.size() != 3) {
            throw new IllegalArgumentException("Not Valid Input");
        }
    }

    private void printCourseMissionInputGuide() {
        println("#############################################\n"
                + "과정: 백엔드 | 프론트엔드\n"
                + "미션:\n"
                + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
                + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
                + "  - 레벨3: \n"
                + "  - 레벨4: 성능개선 | 배포\n"
                + "  - 레벨5: \n"
                + "############################################\n"
                + "과정, 레벨, 미션을 선택하세요.\n"
                + "ex) 백엔드, 레벨1, 자동차경주");
    }

    private String readLine() {
        return Console.readLine().trim();
    }

    private void println(String message) {
        System.out.println(message);
    }

}
