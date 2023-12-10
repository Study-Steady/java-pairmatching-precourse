package pairmatching.view;

import java.util.stream.Collectors;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.parimatching.Pair;
import pairmatching.domain.parimatching.PairMatchingHistory;
import pairmatching.view.utils.ErrorMessageFormatter;

public class OutputView {

    public void showPairMatchingHistory(PairMatchingHistory history) {
        println("페어 매칭 결과입니다.");
        println(toPairMatchingFormat(history));
    }

    private String toPairMatchingFormat(PairMatchingHistory history) {
        return history.getPairs()
                .stream()
                .map(this::toOnePairFormat)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String toOnePairFormat(Pair pair) {
        return pair.getCrews()
                .stream()
                .map(Crew::getName)
                .collect(Collectors.joining(" : "));
    }

    public void showErrorMessage(String message) {
        println(ErrorMessageFormatter.addErrorPrefix(message));
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void printEmptyLine() {
        System.out.println();
    }

}
