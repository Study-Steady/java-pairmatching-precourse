package pairmatching.view.output;

public class OutputView {
    private final Printer printer;

    public OutputView(Printer printer) {
        this.printer = printer;
    }

    public void printMessage(String message) {
        printer.printMessage(message);
    }

    public void printErrorMessage(Exception e) {
        printer.printMessage(e.getMessage());
    }
}
