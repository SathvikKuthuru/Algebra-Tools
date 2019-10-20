import utils.Expression;

public class Test {
    public static void main(String[] args) {
        Expression expression = new Expression("x+5");
        System.out.println(expression.getUsedExpression());
        System.out.println(expression.getVariable());
    }
}
