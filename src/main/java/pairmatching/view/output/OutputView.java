package pairmatching.view.output;

import java.util.List;
import pairmatching.domain.matching.MatchingRecord;
import pairmatching.domain.matching.dto.MatchingCrews;
import pairmatching.view.output.formatter.OutputFormatter;

public class OutputView implements Printer {

    public void printMatchingResult(MatchingRecord matchingRecord) {
        List<MatchingCrews> matchingCrews = matchingRecord.getCrewMatchingResult();
        System.out.println("\n페어 매칭 결과입니다.");

        matchingCrews.forEach(crews -> {
            String joinedValue = OutputFormatter.joinValue(crews.matchedCrews());
            System.out.println(joinedValue);
        });
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printErrorMessage(Output output) {
        System.out.println("[ERROR] " + output.message);
    }

    @Override
    public void printMessage(Output output) {
        System.out.print(output.message);
    }
}
