package utils;

public class Expression {
    private String rawInput;
    private String usedExpression;
    private char variable;

    public Expression(String argument) {
        this.rawInput = new String(argument);
        this.usedExpression = new String(argument);
        this.variable = '?';
        this.removeSpaces();
        this.deduceVariable();
    }

    public void add(Expression other) {
        this.usedExpression += "+" + other.usedExpression;
    }

    public void subtract(Expression other) {
        this.usedExpression += "-" + other.usedExpression;
    }

    public void multiply(Expression other) {
        this.usedExpression += "*" + other.usedExpression;
    }

    public void divide(Expression other) {
        this.usedExpression += "/" + other.usedExpression;
    }

    public String getRawInput() {
        return this.rawInput;
    }

    public String getUsedExpression() {
        return this.usedExpression;
    }

    public char getVariable() {
        return this.variable;
    }

    public void removeSpaces() {
        StringBuilder resultingExpression = new StringBuilder("");
        for(char c : usedExpression.toCharArray()) {
            if(c != ' ') resultingExpression.append(c);
        }
        usedExpression = resultingExpression.toString();
    }

    public void deduceVariable() {
        for(char c : usedExpression.toCharArray()) {
            if(Character.isAlphabetic(c)) {
                variable = c;
                return;
            }
        }
    }
}
