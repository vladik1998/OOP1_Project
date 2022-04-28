package Multi;
import Number.Scalar;
import Number.Integer;


public class Monomial {

    private int exponent;
    private Scalar coefficient;

    public Monomial(Scalar coefficient, int exponent) {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public Scalar getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Scalar coefficient) {
        this.coefficient = coefficient;
    }

    public Monomial add(Monomial m) {
        if (this.exponent != m.getExponent())
            return null;
        else {
            return new Monomial(coefficient.add(m.getCoefficient()), exponent);
        }
    }

    public Monomial mul(Monomial m) {
        return new Monomial(coefficient.mul(m.coefficient), exponent + m.getExponent());
    }

    public Scalar evaluate(Scalar s) {
        Scalar x = s.power(exponent);
        return coefficient.mul(x);
    }

    public Monomial derivative() {
        Scalar ResCoef;
        if (exponent == 0) {
            ResCoef = new Integer(0);
            return new Monomial(ResCoef, 0);
        } else {
            ResCoef = coefficient.mul(new Integer(exponent));
            return new Monomial(ResCoef, exponent - 1);
        }
    }

    public int sign() {
        return coefficient.sign();
    }

    public String toString() {
        if (exponent == 0) {
            return coefficient.toString();
        } else if (exponent == 1) {
            return coefficient.toString() + "x";
        } else if (coefficient.getDoubleValue() == 1) {
            return "x^" + exponent;
        } else if (coefficient.getDoubleValue() == -1) {
            return "-x^" + exponent;
        } else {
            return coefficient.toString() + "x^" + exponent;
        }
    }
}
