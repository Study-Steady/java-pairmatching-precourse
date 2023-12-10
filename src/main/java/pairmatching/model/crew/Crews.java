package pairmatching.model.crew;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Crews {
    private static final Map<Crew, Integer> backendCrewToIndex = new HashMap<>();
    private static final Map<Crew, Integer> frontendCrewToIndex = new HashMap<>();

    private final List<Crew> backendCrews;
    private final List<Crew> frontendCrews;

    private Crews(List<Crew> backendCrews, List<Crew> frontendCrews) {
        this.backendCrews = backendCrews;
        this.frontendCrews = frontendCrews;
    }

    public static Crews of(List<Crew> backendCrews, List<Crew> frontendCrews) {
        for (int i = 0; i < backendCrews.size(); i++) {
            backendCrewToIndex.put(backendCrews.get(i), i);
        }

        for (int i = 0; i < frontendCrews.size(); i++) {
            frontendCrewToIndex.put(frontendCrews.get(i), i);
        }
        return new Crews(backendCrews, frontendCrews);
    }

    public List<String> getCrewNames(Course course) {
        if (course == Course.BACKEND) {
            return backendCrews.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
        }
        return frontendCrews.stream()
            .map(Crew::getName)
            .collect(Collectors.toList());
    }

    public int getCrewIndex(Course course, Crew crew) {
        if (course == Course.BACKEND) {
            return backendCrewToIndex.get(crew);
        }
        return frontendCrewToIndex.get(crew);
    }
}
