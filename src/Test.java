import utils.Expression;
import utils.ExpressionValidator;

public class Test {
    public static void main(String[] args) {
        Expression expression = new Expression("(x+5)(4+2))");
        ExpressionValidator expressionValidator = new ExpressionValidator(expression);
        System.out.println(expression.getUsedExpression());
        System.out.println(expression.getVariable());
        System.out.println(expressionValidator.validate().getErrorMessage());
    }
}
