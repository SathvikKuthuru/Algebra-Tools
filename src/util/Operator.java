package utils;

public enum Operator implements ExpressionSyntax{
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

    private Operator(Character eq) {
        this.equivalent = eq;
    }
}