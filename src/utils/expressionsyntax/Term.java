package utils.expressionsyntax;

public class Term implements Syntax {
    int coefficient;
    int exponent;
    Character variable;

    public Term(int c, int exp, Character v) {
        this.coefficient = c;
        this.exponent = exp;
        this.variable = v;
    }
}
