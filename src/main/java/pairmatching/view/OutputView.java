package pairmatching.view;

import pairmatching.view.utils.ErrorMessageFormatter;

public class OutputView {

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
