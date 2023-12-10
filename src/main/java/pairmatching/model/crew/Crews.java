package pairmatching.model.crew;

import java.util.List;

public class Crews {
    private final List<Crew> backendCrews;
    private final List<Crew> frontendCrews;

    private Crews(List<Crew> backendCrews, List<Crew> frontendCrews) {
        this.backendCrews = backendCrews;
        this.frontendCrews = frontendCrews;
    }

    public static Crews of(List<Crew> backendCrews, List<Crew> frontendCrews) {
        return new Crews(backendCrews, frontendCrews);
    }

    public List<String> getBackendCrewNames() {
        return backendCrews.stream()
            .map(Crew::getName)
            .toList();
    }

    public List<String> getFrontendCrewNames() {
        return frontendCrews.stream()
            .map(Crew::getName)
            .toList();
    }
}
