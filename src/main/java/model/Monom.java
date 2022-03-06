package model;

public class Monom {
    public int degree;
    public float coefficient;
    public int flag;
    public Monom(int degree, float coefficient) {
        this.degree = degree;
        this.coefficient = coefficient;
    }
    public Monom(int falg) {
        this.flag = flag;
    }

    public int getDegree() {
        return degree;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }
    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
    //cum sa afisez un monom
    @Override
    public String toString()
    {
        String monom="";
        if(this.coefficient>0)
            monom=new String("+" +(int) this.coefficient +"x^" +this.degree);
        else if (this.coefficient < 0)
            monom=new String ( (int)this.coefficient + "x^"+ this.degree);
        return monom;
    }
    //pentru integrare deoarece afisez coeficientul ca si float
    public String toString2()
    {   String coef=String.format("%.02f",this.coefficient);
        String monom="";
        if(this.coefficient>0)
            monom=new String("+" + coef +"x^" +this.degree);
        else if (this.coefficient < 0)
            monom=new String ( coef + "x^"+this.degree);
        return monom;
    }
}
