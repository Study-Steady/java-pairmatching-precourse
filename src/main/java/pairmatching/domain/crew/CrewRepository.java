package pairmatching.domain.crew;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Course;

public class CrewRepository {

    private final List<Crew> crews;

    private CrewRepository(List<Crew> crews) {
        this.crews = crews;
    }

    public static CrewRepository initialize() {
        // 마크다운 파일 읽어와서, crew 형태로 변경
        return null;
    }

    public List<Crew> getCrews() {
        return Collections.unmodifiableList(crews);
    }

    public List<Crew> fetchBackendCrewNames() {
        return null;
    }

    public List<Crew> getCrewsBy(Course course) {
        return this.crews.stream()
                .filter(crew -> crew.matchesCourse(course))
                .collect(Collectors.toList());
    }

    public Crew getBy(Course course, String crewName) {
        return this.crews.stream()
                .filter(crew -> crew.matchesCourse(course))
                .filter(crew -> crew.matchesName(crewName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No Crew Exist."));
    }

    public List<Crew> findAllBy(Course course, List<String> crewNames) {
        return crewNames.stream()
                .map(crewName -> getBy(course, crewName))
                .collect(Collectors.toList());
    }

}
