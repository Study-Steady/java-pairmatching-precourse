package pairmatching.model.crew;

public enum Mission {
    RACING_CAR("자동차 경주"),
    LOTTO("로또"),
    NUMBER_BASEBALL("숫자 야구"),
    SHOPPING_BASKET("장바구니"),
    PAYMENT("결제"),
    SUBWAY_LINE("지하철 노선도"),
    IMPROVEMENT("성능개선"),
    DEPLOYMENT("배포"),
    ;

    private final String name;

    Mission(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
