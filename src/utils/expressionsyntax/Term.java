package utils.expressionsyntax;

import java.math.BigInteger;

public class Term implements Syntax {
    private BigInteger coefficient;
    private BigInteger exponent;
    private Character variable;

    public Term(String c, String exp, Character v) {
        this.coefficient = new BigInteger(c);
        this.exponent = new BigInteger(exp);
        this.variable = v;
    }

    public BigInteger getCoefficient() {
        return this.coefficient;
    }

    public BigInteger getExponent() {
        return this.getExponent();
    }

    public Character getVariable() {
        return this.variable;
    }

    @Override
    public String toString() {
        return coefficient + " " + variable + " " + exponent;
    }
}
