package pairmatching.view.formatter;

import java.util.List;
import pairmatching.common.Symbol;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;

public class OutputFomatter {
    public static final String WINNERS_SEPARATOR = Symbol.COMMA;

    public static String toPairMatching(Pair pair) {
        List<Crew> crews = pair.getCrews();
        return String.join(" : ", crews);
}
