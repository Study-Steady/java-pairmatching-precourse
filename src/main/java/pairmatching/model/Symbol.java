package pairmatching.model;

public enum Symbol {
    COMMA(","),
    NEW_LINE(System.lineSeparator()),
    BLANK(" ");

    private String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
