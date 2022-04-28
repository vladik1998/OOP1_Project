package Number;

public class Rational implements Scalar {

    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0)
            throw new IllegalArgumentException("Cannot devide by 0!");
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }


    public Scalar add(Scalar s) {
        return s.addRational(this);
    }

    public Scalar mul(Scalar s) {
        return s.mulRational(this);
    }

    public Scalar addInteger(Integer s){
        Rational res= new Rational(denominator*s.getNumber()+numerator,denominator);
        return res.reduce();
    }
    public Scalar addRational(Rational s){
        Rational res= new Rational(numerator*s.getDenominator()+s.getNumerator()*denominator,denominator*s.getDenominator());
        return res.reduce();
    }
    public Scalar mulInteger(Integer s){
        Rational res=new Rational(s.getNumber()*numerator,denominator);
        return res.reduce();
    }
    public Scalar mulRational(Rational s){
        Rational res=new Rational(numerator*s.getNumerator(),denominator*s.getDenominator());
        return res.reduce();
    }

    public Scalar neg() {
        return new Rational(numerator*(-1),denominator);
    }

    public Scalar power(int exponent) {
        Scalar r=new Rational(numerator,denominator);
        if(exponent==0)
            return new Rational(1,1);
        else {
            for (int i = 0; i < exponent - 1; i++)
                r = r.mul(this);
            return r;
        }
    }

    public int sign() {
        if (numerator == 0)
            return 0;
        else if (numerator * denominator > 0)
            return 1;
        else return -1;
    }

    public Rational reduce() {
        int gcd = gcd(numerator, denominator);
        return new Rational(numerator / gcd, denominator / gcd);
    }

    private int gcd(int num1, int num2) {
        int m = num1;
        int n = num2;
        int r = m % n;
        while (r != 0) {
            m = n;
            n = r;
            r = m % n;
        }
        return n;
    }

    public String toString() {
        Rational res = reduce();
        int sign = sign();
        if (sign > 0) {
            if (res.getDenominator() == 1) {
                return "" + res.getNumerator();
            }
            return "" + res.getNumerator() + "/" + res.getDenominator();
        } else if (sign == 0)
            return "" + 0;
        else {
            if (res.getDenominator() == 1) {
                return "" + res.getNumerator();
            }
            if (res.getDenominator() < 0)
                return "" + res.getNumerator() * -1 + "/" + res.getDenominator() * -1;
            return "" + res.getNumerator() + "/" + res.getDenominator();
        }

    }

    public double getDoubleValue(){
        return (double) numerator/denominator;
    }
}