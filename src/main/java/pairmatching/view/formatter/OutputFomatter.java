package pairmatching.view.formatter;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;

public class OutputFomatter {
    public static String toPairMatching(Pair pair) {
        List<Crew> crews = pair.getCrews();
        return crews.stream()
                .map(crew -> crew.getCrewName().getCrewName())
                .collect(Collectors.joining(" : "));
    }
}
