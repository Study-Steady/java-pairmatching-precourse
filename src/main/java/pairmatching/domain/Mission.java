package pairmatching.domain;

import java.util.Arrays;

public enum Mission {
    RACING_CAR("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    NUMBER_BASEBALL("숫자야구게임", Level.LEVEL1),
    SHOPPING_CART("장바구니", Level.LEVEL2),
    PAYMENT("결제", Level.LEVEL2),
    SUBWAY_MAP("지하철노선도", Level.LEVEL2),
    PERFORMANCE_IMPROVEMENT("성능개선", Level.LEVEL4),
    DEPLOYMENT("배포", Level.LEVEL4);

    private String missionName;
    private Level level;

    Mission(String missionName, Level level) {
        this.missionName = missionName;
        this.level = level;
    }

    public static Mission of(Level levelInput, String missionInput) { // @ 테스트 필요
        return Arrays.stream(values())
                .filter(mission -> mission.missionName.equals(missionInput) && mission.level.equals(levelInput))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("레벨에 해당하는 미션이 존재하지 않습니다.."));
    }
}
