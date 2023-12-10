package pairmatching.domain.crew;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import pairmatching.domain.Course;
import pairmatching.domain.Mission;

// 크루 이름은 중복 없음
public class Crew {

    private final Course course;
    private final String name;
    private final Map<Mission, Crew> metHistory = new HashMap<>();

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public boolean hasMet(Mission mission, Crew otherCrew) {
        return this.metHistory.entrySet()
                .stream()
                .filter(entry -> entry.getKey().is(mission))
                .anyMatch(entry -> entry.getValue().equals(otherCrew));
    }

    public boolean hasMet(Mission mission, List<Crew> crews) {
        return crews.stream()
                .anyMatch(otherCrew -> hasMet(mission, otherCrew));
    }

    public void addMetHistory(Mission mission, Crew otherCrew) {
        this.metHistory.put(mission, otherCrew);
    }

    public void addMetHistory(Mission mission, List<Crew> otherCrews) {
        otherCrews.forEach(othreCrew -> addMetHistory(mission, othreCrew));
    }

    public boolean matchesCourse(Course course) {
        return this.course.is(course);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Crew crew = (Crew) o;
        return course == crew.course && Objects.equals(name, crew.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, name);
    }

    public boolean matchesName(String crewName) {
        return this.name.equals(crewName);
    }

}
