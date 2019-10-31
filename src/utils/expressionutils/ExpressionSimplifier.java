package utils.expressionutils;

public class ExpressionSimplifier {
    Expression toSimplify;
    Expression simplifiedExpression;
    ExpressionValidator expressionValidator;
    ExpressionError expressionError;

    public ExpressionSimplifier(Expression input) {
        this.toSimplify = input;
        this.expressionValidator = new ExpressionValidator(toSimplify);
        this.expressionError = expressionValidator.validate();
        this.simplifiedExpression = new Expression("");
    }

    public Expression simplify() {
        if (expressionError != ExpressionError.NO_ERROR) return null;
        return simplifiedExpression;
    }


}
