package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Crew {
    private final String name;
    private List<String> previousPairs = new ArrayList<>();

    public Crew(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPreviousPair(String name) {
        previousPairs.add(name);
    }

    public boolean alreadyPaired(String name) {
        return previousPairs.contains(name);
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
        return Objects.equals(name, crew.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Crew{" +
                "name='" + name + '\'' +
                ", previousPairs=" + previousPairs +
                '}';
    }
}
