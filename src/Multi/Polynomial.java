package Multi;
import Number.Scalar;
import Number.Integer;
import Number.Rational;


import java.util.ArrayList;

public class Polynomial {

    private ArrayList<Monomial> monomials;

    public Polynomial(){
        ArrayList<Monomial> monomials=new ArrayList<>();
        this.monomials=monomials;
    }
    public Polynomial(ArrayList<Monomial> monomials){
        this.monomials=monomials;
    }

    public ArrayList<Monomial> getMonomials(){
        return monomials;
    }

    public static Polynomial build(String input) {
        Polynomial pol=new Polynomial();
        Scalar tempSc;
        String[] arrOfScalar=input.split("\s+");
        for (int i = 0; i <arrOfScalar.length; i++) {
            if(arrOfScalar[i].indexOf("/")!=-1){
                tempSc=pol.makeRational(arrOfScalar[i]);
            }else{
                tempSc=new Integer(java.lang.Integer.parseInt(arrOfScalar[i]));
            }
            pol.getMonomials().add(new Monomial(tempSc,i));
        }
        return pol;
    }

    private Scalar makeRational(String s){
        String[] NumAndDem=s.split("/");
        return new Rational(java.lang.Integer.parseInt(NumAndDem[0]),java.lang.Integer.parseInt(NumAndDem[1]));
    }

    public Polynomial add(Polynomial p){
        ArrayList<Monomial> pMono=p.getMonomials();
        ArrayList<Monomial> res=new ArrayList<>();
        int index=0;
        if(pMono.size()>=monomials.size()) {
            for (int i = 0; i < monomials.size(); i++) {
                Scalar pSc=pMono.get(i).getCoefficient();
                Scalar thisSc=monomials.get(i).getCoefficient();
                res.add(new Monomial(pSc.add(thisSc),i));
                index++;
            }
            while (index<pMono.size()){
                res.add(pMono.get(index));
                index++;
            }
        }else {
            for (int i = 0; i < pMono.size(); i++) {
                Scalar pSc = pMono.get(i).getCoefficient();
                Scalar thisSc = monomials.get(i).getCoefficient();
                res.add(new Monomial(pSc.add(thisSc), i));
                index++;
            }
            while (index < monomials.size()) {
                res.add(monomials.get(index));
                index++;
            }
        }
        return new Polynomial(res);
    }
    public Polynomial mul(Polynomial p){
        ArrayList<Monomial> pMono=p.getMonomials();
        int maxExp=(pMono.size()-1)+(monomials.size()-1);
        int newSize=maxExp+1;
        ArrayList<Monomial> res=BuildList(newSize);
        for (int i = 0; i < monomials.size(); i++) {
            for (int j = 0; j < pMono.size(); j++) {
                Monomial tempMono=monomials.get(i).mul(pMono.get(j));
                int newExp=tempMono.getExponent();
                tempMono=tempMono.add(res.get(newExp));
                res.set(newExp,tempMono);
            }
        }
        return new Polynomial(res);
    }

    private ArrayList<Monomial> BuildList(int size){
        ArrayList<Monomial> res=new ArrayList<>();
        if(size==0) {
            res.add(new Monomial(new Integer(0), 0));
        } else {
            for (int i = 0; i < size; i++) {
                res.add(new Monomial(new Integer(0), i));
            }
        }
        return res;
    }

    public Scalar evaluate(Scalar s){
        Scalar res=monomials.get(0).evaluate(s);
        for (int i = 1; i < monomials.size(); i++) {
            res=res.add(monomials.get(i).evaluate(s));
        }
        return res;
    }
    public Polynomial derivative(){
        ArrayList <Monomial> res=BuildList(monomials.size()-1);
        for (int i = 1; i < monomials.size(); i++) {
            res.set(i-1,monomials.get(i).derivative());
        }
        return new Polynomial(res);
    }
    public String toString(){
        String res="";
        if (AllZero(monomials))
            return "0";
        for (Monomial m:monomials) {
            Scalar tempSc=m.getCoefficient();
            if(!tempSc.toString().equals("0")){
                if(tempSc.sign()>0)
                    res+="+"+m;
                else
                    res+=m.toString();
            }
        }
        if(res.charAt(0)=='-')
            return res;
        else return res.substring(1);
    }

    private boolean AllZero(ArrayList<Monomial> arr){
        for (Monomial m:arr) {
            if(!m.getCoefficient().toString().equals("0"))
                return false;
        }
        return true;
    }
}
