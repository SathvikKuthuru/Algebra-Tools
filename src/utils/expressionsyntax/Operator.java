package utils.expressionsyntax;

public enum Operator implements Syntax {
    ADDITION('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/'),
    OPEN_PARENTHESES('('),
    CLOSED_PARENTHESES(')'),
    EXPONENT('^');

    private Character equivalent;

    public Character getEquivalent() {
        return this.equivalent;
    }

    @Override
    public String toString() {
        return equivalent + "";
    }


    private Operator(Character eq) {
        this.equivalent = eq;
    }
}
