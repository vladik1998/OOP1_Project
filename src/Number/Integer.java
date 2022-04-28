package Number;

public class Integer implements Scalar {

    private int number;

    public Integer(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String toString() {
        return ""+number;
    }


    public Scalar add(Scalar s) {
        return s.addInteger(this);
    }

    public Scalar mul(Scalar s) {
        return s.mulInteger(this);
    }

    public Scalar addInteger(Integer s){
        return new Integer(s.getNumber()+number);
    }
    public Scalar addRational(Rational s){
        return new Rational(s.getDenominator()*number+s.getNumerator(),s.getDenominator());
    }
    public Scalar mulInteger(Integer s){
        return new Integer(number*s.getNumber());
    }
    public Scalar mulRational(Rational s){
        Rational res=new Rational(number*s.getNumerator(),s.getDenominator());
        return res.reduce();
    }

    public Scalar neg() {
        return new Integer(number*(-1));
    }

    public Scalar power(int exponent) {
        return new Integer((int)Math.pow(number,exponent));
    }

    public int sign() {
        if(number==0)
            return 0;
        else if(number>0)
            return 1;
        else return -1;
    }

    public double getDoubleValue(){
        return number;
    }
}
