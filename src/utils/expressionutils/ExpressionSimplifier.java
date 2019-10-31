package utils.expressionutils;

import utils.expressionsyntax.Operator;
import utils.expressionsyntax.Syntax;
import utils.expressionsyntax.Term;

import java.util.ArrayList;

public class ExpressionSimplifier {
    private Expression toSimplify;
    private Expression simplifiedExpression;
    private ExpressionValidator expressionValidator;
    private ExpressionError expressionError;
    private ArrayList<Syntax> expressionSyntax;

    public ExpressionSimplifier(Expression input) {
        this.toSimplify = input;
        this.expressionValidator = new ExpressionValidator(toSimplify);
        this.expressionError = expressionValidator.validate();
        this.simplifiedExpression = new Expression("");
        this.expressionSyntax = new ArrayList<>();
    }

    public void convertRawToSyntax() {
        if(expressionError != ExpressionError.NO_ERROR) return;
        boolean[] usedForTerm = new boolean[toSimplify.getUsedExpression().length()];
        for(int i = 0; i < toSimplify.getUsedExpression().length(); i++) {
            if(usedForTerm[i]) continue;
            Syntax toAdd = null;
            Operator currOperator = getOperator(i);
            if(currOperator != null) toAdd = currOperator;
            else toAdd = parseTerm(i, usedForTerm);
            expressionSyntax.add(toAdd);
        }
    }

    public Term parseTerm(int index, boolean[] used) {
        StringBuilder currentCoefficient = new StringBuilder();
        StringBuilder currentExponent = new StringBuilder();
        boolean switchNext = false;
        boolean hasVariable = false;
        int endIndex = index;
        int coefficientIndex = -1;
        for(int i = index; i < toSimplify.getUsedExpression().length(); i++) {
            Operator check = getOperator(i);
            if(check != null && !check.equals(Operator.EXPONENT)) break;
            endIndex = i;
            Character current = toSimplify.getUsedExpression().charAt(index);
            if(current.equals(toSimplify.getVariable())) {
                hasVariable = true;
                continue;
            }
            if(check != null && check.equals(Operator.EXPONENT)) {
                switchNext = true;
                continue;
            }
            if(switchNext) currentExponent.append(current);
            else {
                currentCoefficient.append(current);
                coefficientIndex = i;
            }
        }
        if(currentCoefficient.length() == 0) currentCoefficient.append('1');
        if(currentExponent.length() == 0) currentExponent.append('1');
        Term toReturn;
        if(!hasVariable) {
            for(int i = index; i <= coefficientIndex; i++) used[i] = true;
            toReturn = new Term(currentCoefficient.toString(), currentExponent.toString(), null);
        }
        else {
            for (int i = index; i <= endIndex; i++) used[i] = true;
            toReturn = new Term(currentCoefficient.toString(), currentExponent.toString(), toSimplify.getVariable());
        }
        return toReturn;
    }

    public Operator getOperator(int index) {
        Character current = toSimplify.getUsedExpression().charAt(index);
        for(Operator o : Operator.values()) {
            if(current.equals(o.getEquivalent())) {
                return o;
            }
        }
        return null;
    }

    public Expression getSimplifiedExpression() {
        return simplifiedExpression;
    }

    public Expression getToSimplify() {
        return toSimplify;
    }

    public ExpressionError getExpressionError() {
        return expressionError;
    }

    public ExpressionValidator getExpressionValidator() {
        return expressionValidator;
    }

    public ArrayList<Syntax> getExpressionSyntax() {
        return expressionSyntax;
    }

    public Expression simplify() {
        if (expressionError != ExpressionError.NO_ERROR) return null;
        return simplifiedExpression;
    }


}
