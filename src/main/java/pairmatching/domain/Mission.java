package pairmatching.domain;

import java.util.stream.Stream;

public enum Mission {

    RACING_CAR("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    BASEBALL_GAME("숫자야구게임", Level.LEVEL1),
    BASKET("장바구니", Level.LEVEL2),
    PAYMENT("결제", Level.LEVEL2),
    SUBWAY("지하철노선도", Level.LEVEL2),
    IMPROVEMENT("성능개선", Level.LEVEL4),
    DEPLOY("배포", Level.LEVEL4);

    private final String name;
    private final Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public static Mission getBy(String name) {
        return Stream.of(Mission.values())
                .filter(mission -> mission.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("No Matching Mission for name=%s", name)
                ));
    }

    public String getName() {
        return name;
    }

    public boolean is(Mission mission) {
        return this == mission;
    }

    public boolean matchesLevel(Level level) {
        return this.level == level;
    }

}
