package pairmatching.domain.crew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Course;
import pairmatching.utils.FileIO;

public class CrewRepository {

    private static final String BACKEND_CREW_FILE_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_CREW_FILE_PATH = "src/main/resources/frontend-crew.md";

    private final List<Crew> crews = new ArrayList<>();

    private CrewRepository() {
    }

    public static CrewRepository initialize() {
        CrewRepository crewRepository = new CrewRepository();

        crewRepository.addAll(setUpCrew(Course.BACKEND, BACKEND_CREW_FILE_PATH));
        crewRepository.addAll(setUpCrew(Course.FRONTEND, FRONTEND_CREW_FILE_PATH));

        System.out.println(Arrays.toString(crewRepository.crews.toArray()));
        return crewRepository;
    }

    private void addAll(List<Crew> crews) {
        this.crews.addAll(crews);
    }

    private static List<Crew> setUpCrew(Course course, String filePath) {
        return FileIO.readByLines(filePath)
                .stream()
                .map(crewName -> new Crew(course, crewName))
                .collect(Collectors.toList());
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
