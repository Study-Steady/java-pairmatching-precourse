package pairmatching.view;


import pairmatching.common.Symbol;
import pairmatching.domain.CurriculumDetail;
import pairmatching.domain.MainOption;
import pairmatching.domain.RematchOption;
import pairmatching.util.converter.Converter;
import pairmatching.view.printer.Printer;
import pairmatching.view.reader.Reader;
import pairmatching.view.validator.InputValidator;

public class InputView {
    public static final String SEPARATOR_LINE = "#############################################";
    private final Reader reader;
    private final Printer printer;
    private final InputValidator validator;

    private InputView(Reader reader, Printer printer, InputValidator validator) {
        this.reader = reader;
        this.printer = printer;
        this.validator = validator;
    }

    public static InputView of(Reader reader, Printer printer) {
        return new InputView(reader, printer, InputValidator.getInstance());
    }

    public MainOption inputMainOption() {
        printer.printLine("기능을 선택하세요.");
        printer.printLine("1. 페어 매칭");
        printer.printLine("2. 페어 조회");
        printer.printLine("3. 페어 초기화");
        printer.printLine("Q. 종료");
        String mainOption = reader.readLine();
        printer.printEmptyLine();
        validator.validateMainOption(mainOption, "기능 선택");
        return MainOption.from(mainOption);
    }

    public CurriculumDetail inputCurriculumDetail() {
        printer.printLine(SEPARATOR_LINE);
        printer.printLine("과정: 백엔드 | 프론트엔드");
        printer.printLine("미션:");
        printer.printLine("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임");
        printer.printLine("  - 레벨2: 장바구니 | 결제 | 지하철노선도");
        printer.printLine("  - 레벨3: ");
        printer.printLine("  - 레벨4: 성능개선 | 배포");
        printer.printLine("  - 레벨5: ");
        printer.printLine(SEPARATOR_LINE);
        printer.printLine("과정, 레벨, 미션을 선택하세요.");
        printer.printLine("ex) 백엔드, 레벨1, 자동차경주");
        String curriculumDetail = reader.readLine();
        validator.validateCurriculumDetail(curriculumDetail, "과정, 레벨, 미션");
        return CurriculumDetail.of(Converter.splitToTrimedList(Symbol.COMMA, curriculumDetail));
    }

    public RematchOption inputRematchOption() {
        printer.printLine("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        String rematchOption = reader.readLine();
        validator.validateRematchOption(rematchOption, "재매치 여부");
        return RematchOption.from(rematchOption);
    }
}
