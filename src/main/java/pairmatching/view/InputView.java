package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
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

    private String readLine() {
        return Console.readLine().trim();
    }

    private void println(String message) {
        System.out.println(message);
    }

}
