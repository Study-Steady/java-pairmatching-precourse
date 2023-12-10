package pairmatching.view.validator;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.LevelInfos;
import pairmatching.util.StringConvertor;

public class MatchingOptionValidator {
    private static final int OPTIONS_SIZE = 3;

    private MatchingOptionValidator() {
    }

    public static void validate(String input) {
        String[] options = StringConvertor.splitByComma(input);
        validateInputFormat(options);
        validateCourseExist(options[0]);
        validateMissionExist(options);
    }

    private static void validateInputFormat(String[] options) {
        if (options.length != OPTIONS_SIZE) {
            throw new IllegalArgumentException("입력 예시 형식에 맞게 입력해주세요.");
        }
    }

    private static void validateCourseExist(String optionName) {
        if (!Course.contains(optionName)) {
            throw new IllegalArgumentException("존재하지 않는 코스명입니다.");
        }
    }

    private static void validateMissionExist(String[] options) {
        LevelInfos levelInfos = LevelInfos.getInstance();
        if (!levelInfos.isLevelContains(options[1], options[2])) {
            throw new IllegalArgumentException("해당 레벨에 존재하지 않는 미션입니다.");
        }
    }
}
