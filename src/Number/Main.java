package Number;

import Multi.Monomial;
import Multi.Polynomial;


import java.util.ArrayList;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {

        Rational in1=new Rational(-8,7);
        Rational in3=new Rational(4,-7);
        Scalar n=in1.power(4);
        Integer in=new Integer(3);
        Integer in2=new Integer(5);
//        System.out.println(in1.mul(in));
//        System.out.println(in1.add(in3));
//        System.out.println(in.getDoubleValue());
//        System.out.println(in1.getDoubleValue());
//        Monomial mon=new Monomial(in,0);
//        System.out.println(mon);
//        Monomial der=mon.derivative();
//        System.out.println(der);
//        String s="7   5    6  8/3  -2";
//        String[] arrOfScalar=s.split("\s+");
//        System.out.println(Arrays.toString(arrOfScalar));
//        for(String i: arrOfScalar){
//            System.out.println(i);
//        }
//        String t="-2/-9";
//        //System.out.println(Integer.parseInt(t));
//
//        String[] NumAndDem=t.split("/");
//        Rational r=new Rational(Integer.parseInt(NumAndDem[0]),Integer.parseInt(NumAndDem[1]));
//        System.out.println(r);

        Monomial m=new Monomial(new Integer(0),0);
        Polynomial p= Polynomial.build("0 0 0 0 ");
        Polynomial pi= Polynomial.build("0 0 0 0 0 0 4 -5/2");
        System.out.println(Arrays.toString(p.getMonomials().toArray()));
        //System.out.println(p.derivative());
        //System.out.println(pi);


    }
}
