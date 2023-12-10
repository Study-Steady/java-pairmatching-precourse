package pairmatching.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LevelInfos {
    private Map<Level, List<Mission>> levelInfos;

    private LevelInfos(Map<Level, List<Mission>> levelInfos) {
        this.levelInfos = levelInfos;
    }

    public static LevelInfos getInstance() {
        Map<Level, List<Mission>> levelInfos = new HashMap<>();
        levelInfos.put(Level.LEVEL1, Arrays.asList(Mission.CAR_RACING, Mission.LOTTO, Mission.NUMBER_BASEBALL));
        levelInfos.put(Level.LEVEL2, Arrays.asList(Mission.CART, Mission.PAYMENT, Mission.SUBWAY_MAP));
        levelInfos.put(Level.LEVEL4, Arrays.asList(Mission.PERFORMANCE_IMPROVEMENTS, Mission.DEPLOYMENT));
        return new LevelInfos(levelInfos);
    }

    public List<String> getMissionNamesOfLevel(Level level) {
        List<Mission> missions = levelInfos.get(level);
        if (missions == null) {
            return Collections.singletonList("");
        }
        return missions.stream()
                .map(Mission::getName)
                .collect(Collectors.toList());
    }

    public boolean isLevelContains(String levelName, String missionName) {
        Level level = Level.getByName(levelName);
        Mission mission = Mission.getByName(missionName);
        List<Mission> missions = levelInfos.get(level);
        return missions != null && missions.contains(mission);
    }
}

