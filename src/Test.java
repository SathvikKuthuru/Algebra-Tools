import utils.expressionsyntax.Syntax;
import utils.expressionutils.Expression;
import utils.expressionutils.ExpressionSimplifier;
import utils.expressionutils.ExpressionValidator;

public class Test {
    public static void main(String[] args) {
        Expression expression = new Expression("(x+5)(4+2)");
        ExpressionValidator expressionValidator = new ExpressionValidator(expression);
        ExpressionSimplifier expressionSimplifier = new ExpressionSimplifier(expression);

        System.out.println(expression.getUsedExpression());
        System.out.println(expression.getVariable());
        System.out.println(expressionValidator.validate().getErrorMessage());
        expressionSimplifier.convertRawToSyntax();
        for(Syntax s : expressionSimplifier.getExpressionSyntax()) {
            System.out.println(s);
        }
    }
}
