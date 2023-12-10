package pairmatching.view.input.validator;

import java.util.Arrays;
import java.util.List;
import pairmatching.domain.course.Course;
import pairmatching.domain.level.Level;
import pairmatching.domain.matching.dto.MatchingSelection;
import pairmatching.domain.mission.Mission;
import pairmatching.view.input.error.InputError;
import pairmatching.view.input.error.InputIllegalArgumentException;

public class MatchingSelectionValidator {

    public MatchingSelection validate(String inputValue) {
        validateNotBlank(inputValue);
        List<String> matchingSelections = divideToList(inputValue);
        validateAllAnswered(matchingSelections);
        Course course = validateExistCourse(matchingSelections.get(0));
        Mission mission = validateExistMission(matchingSelections.get(2));
        Level level = validateExistLevelMission(matchingSelections.get(1), mission);

        return new MatchingSelection(course, level, mission);
    }

    private void validateNotBlank(String inputValue) {
        if (inputValue.isBlank()) {
            throw new InputIllegalArgumentException(InputError.INPUT_IS_BLANK);
        }
    }

    private List<String> divideToList(String inputValue) {
        return Arrays.stream(inputValue.split(","))
                .map(String::trim)
                .toList();
    }

    private void validateAllAnswered(List<String> inputValue) {
        if (inputValue.size() != 3) {
            throw new InputIllegalArgumentException(InputError.NOT_POSSIBLE_INPUT);
        }
    }

    private Course validateExistCourse(String inputValue) {
        return Course.getCourseByType(inputValue);
    }

    private Mission validateExistMission(String inputValue) {
        return Mission.getMissionByName(inputValue);
    }

    private Level validateExistLevelMission(String inputValue, Mission mission) {
        return Level.getLevelByStepAndMission(inputValue, mission);
    }
}
