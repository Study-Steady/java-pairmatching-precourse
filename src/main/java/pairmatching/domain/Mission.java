package pairmatching.domain;

import java.util.EnumSet;

public enum Mission {
    CAR_RACING("자동차경주"),
    LOTTO("로또"),
    NUMBER_BASEBALL("숫자야구게임"),
    CART("장바구니"),
    PAYMENT("결제"),
    SUBWAY_MAP("지하철노선도"),
    PERFORMANCE_IMPROVEMENTS("성능개선"),
    DEPLOYMENT("배포");

    private final String name;

    Mission(String name) {
        this.name = name;
    }

    public static Mission getByName(String name) {
        return EnumSet.allOf(Mission.class).stream()
                .filter(mission -> mission.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 미션입니다."));
    }

    public String getName() {
        return name;
    }
}
