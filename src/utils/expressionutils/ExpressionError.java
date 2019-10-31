package utils.expressionutils;

public enum ExpressionError {
    MISSING_OPEN_PARENTHESES("Missing One Or More Open Parentheses"),
    MISSING_CLOSED_PARENTHESES("Missing One Or More Closed Parentheses"),
    INVALID_VARIABLE("Too Many Variables"),
    UNKNOWN_SYMBOL("Unknown Symbol"),
    EMPTY_EXPRESSION("Empty Expression"),
    NO_ERROR("No Error");

    private String errorMessage;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    private ExpressionError(String in) {
        this.errorMessage = new String(in);
    }

}
