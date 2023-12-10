package pairmatching.view.output;

public class ConsolePrinter implements Printer {
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printEmptyLine() {
        System.out.print(System.lineSeparator());
    }
}
