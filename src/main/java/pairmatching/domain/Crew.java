package pairmatching.domain;

import java.util.Objects;

public class Crew {
    private final Course course;
    private final CrewName crewName;

    public Crew(Course course, CrewName crewName) {
        this.course = course;
        this.crewName = crewName;
    }

    public static Crew of(Course course, String crewName) {
        return new Crew(course, new CrewName(crewName));
    }

    public CrewName getCrewName() {
        return crewName;
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
        return course == crew.course && Objects.equals(crewName, crew.crewName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, crewName);
    }
}

