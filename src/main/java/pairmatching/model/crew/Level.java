package pairmatching.model.crew;

import static pairmatching.model.crew.Mission.DEPLOYMENT;
import static pairmatching.model.crew.Mission.IMPROVEMENT;
import static pairmatching.model.crew.Mission.LOTTO;
import static pairmatching.model.crew.Mission.NUMBER_BASEBALL;
import static pairmatching.model.crew.Mission.PAYMENT;
import static pairmatching.model.crew.Mission.RACING_CAR;
import static pairmatching.model.crew.Mission.SHOPPING_BASKET;
import static pairmatching.model.crew.Mission.SUBWAY_LINE;

import java.util.List;

public enum Level {
    LEVEL1("레벨1", List.of(RACING_CAR, LOTTO, NUMBER_BASEBALL)),
    LEVEL2("레벨2", List.of(SHOPPING_BASKET, PAYMENT, SUBWAY_LINE)),
    LEVEL3("레벨3", List.of()),
    LEVEL4("레벨4", List.of(IMPROVEMENT, DEPLOYMENT)),
    LEVEL5("레벨5", List.of());

    private String name;
    private List<Mission> missions;

    Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public String getName() {
        return name;
    }
}
