package utils;

public class ExpressionValidator {
    Expression toValidate;
    static String validCharacters = "+-*/^012345689()";

    public ExpressionValidator(Expression input) {
        this.toValidate = input;
    }

    public ExpressionError validate() {
        if(toValidate.getUsedExpression() == null) {
            return ExpressionError.EMPTY_EXPRESSION;
        }
        ExpressionError[] checks = {this.checkCharacters(), this.checkVariable(), this.checkParentheses()};
        for(ExpressionError e : checks) {
            if(e != ExpressionError.NO_ERROR) return e;
        }
        return ExpressionError.NO_ERROR;
    }

    public ExpressionError checkParentheses() {
        int parenCount = 0;
        for(char c : toValidate.getUsedExpression().toCharArray()) {
            if(c == '(') parenCount++;
            if(c == ')') parenCount--;
            if(parenCount < 0) return ExpressionError.MISSING_OPEN_PARENTHESES;
        }
        if(parenCount != 0) return ExpressionError.MISSING_CLOSED_PARENTHESES;
        return ExpressionError.NO_ERROR;
    }

    public ExpressionError checkVariable() {
        for(char c : toValidate.getUsedExpression().toCharArray()) {
            if(Character.isAlphabetic(c) && c != toValidate.getVariable()) {
                return ExpressionError.INVALID_VARIABLE;
            }
        }
        return ExpressionError.NO_ERROR;
    }

    public ExpressionError checkCharacters() {
        for(char c : toValidate.getUsedExpression().toCharArray()) {
            if(!Character.isAlphabetic(c) && !validCharacters.contains(c+"")) {
                return ExpressionError.UNKNOWN_SYMBOL;
            }
        }
        return ExpressionError.NO_ERROR;
    }


}
