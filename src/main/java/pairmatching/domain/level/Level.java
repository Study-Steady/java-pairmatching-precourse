package pairmatching.domain.level;

import java.util.Arrays;
import java.util.List;
import pairmatching.domain.mission.Mission;
import pairmatching.view.input.error.InputError;
import pairmatching.view.input.error.InputIllegalArgumentException;

public enum Level {

    LEVEL1("레벨1", List.of(Mission.CAR_GAME, Mission.LOTTO, Mission.NUMBER_BASEBALL)),
    LEVEL2("레벨2", List.of(Mission.SHOPPING_BASKET, Mission.PAYMENT, Mission.SUBWAY_PATH)),
    LEVEL3("레벨3", List.of()),
    LEVEL4("레벨4", List.of(Mission.PERFORMANCE_IMPROVEMENT, Mission.DISTRIBUTION)),
    LEVEL5("레벨5", List.of());

    final String step;
    final List<Mission> missions;

    Level(String step, List<Mission> missions) {
        this.step = step;
        this.missions = missions;
    }

    public static Level getLevelByStepAndMission(String inputValue, Mission mission) {
        Level level = getLevelByStep(inputValue);

        if (!level.missions.contains(mission)) {
            throw new InputIllegalArgumentException(InputError.NOT_POSSIBLE_INPUT);
        }
        return level;
    }

    private static Level getLevelByStep(String inputValue) {
        return Arrays.stream(values())
                .filter(level -> level.step.equals(inputValue))
                .findFirst()
                .orElseThrow(() -> new InputIllegalArgumentException(InputError.NOT_POSSIBLE_INPUT));
    }
}
