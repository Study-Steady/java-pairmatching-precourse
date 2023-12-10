package pairmatching.view;

import java.util.List;
import pairmatching.domain.CurriculumDetail;
import pairmatching.domain.Pair;
import pairmatching.domain.PairsStorage;
import pairmatching.view.formatter.OutputFomatter;
import pairmatching.view.printer.Printer;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] ";
    private final Printer printer;

    public OutputView(Printer printer) {
        this.printer = printer;
    }

//    public void printTemplate(Template rawTemplate) {
//        int template = OutputFomatter.toTemplate(rawTemplate);
//        printer.printLine("%d개", template);
//    }

    public void printExceptionMessage(String message) {
        printer.printLine(ERROR_MESSAGE_FORMAT + message);
        printer.printEmptyLine();
    }

    public void printPairsMatching(PairsStorage pairsStorage, CurriculumDetail curriculumDetail) {
        List<Pair> pairs = pairsStorage.getPairsStorage().get(curriculumDetail).getPairs();

        printer.printLine("페어 매칭 결과입니다.");
        pairs.forEach(this::printPairMatching);

        printer.printEmptyLine();
    }

    private void printPairMatching(Pair pair) {
        String pairMathcing = OutputFomatter.toPairMatching(pair);
        printer.printLine(pairMathcing);
    }
}
