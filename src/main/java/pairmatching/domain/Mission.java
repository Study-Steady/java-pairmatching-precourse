package pairmatching.domain;

import pairmatching.domain.parimatching.PairMatchingRequest;

public enum Mission {

    RACING_CAR("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    BASEBALL_GAME("숫자야구게임", Level.LEVEL1),
    BASKET("장바구니", Level.LEVEL2),
    PAYMENT("결제", Level.LEVEL2),
    SUBWAY("지하철노선도", Level.LEVEL2),
    IMPROVEMENT("성능개선", Level.LEVEL4),
    DEPLOY("배포", Level.LEVEL4);

    private final String description;
    private final Level level;

    Mission(String description, Level level) {
        this.description = description;
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public boolean is(Mission mission) {
        return this == mission;
    }

}
