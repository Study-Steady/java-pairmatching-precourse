package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewsFactory {
    private static final String BACKEND_CREW_MD = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_CREW_MD = "src/main/resources/frontend-crew.md";

    private CrewsFactory() {
    }

    public static Crews createCrewsBy(String options) throws IOException {
        List<Crew> crews = new ArrayList<>();
        BufferedReader reader = null;
        if (options.contains("백엔드")) {
            reader = new BufferedReader(new FileReader(BACKEND_CREW_MD));
        }
        if (options.contains("프론트엔드")) {
            reader = new BufferedReader(new FileReader(FRONTEND_CREW_MD));
        }
        String line;
        while ((line = reader.readLine()) != null) {
            crews.add(new Crew(line));
        }
        reader.close();
        return new Crews(crews);
    }
}
