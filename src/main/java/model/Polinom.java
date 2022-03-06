package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Polinom {
    public ArrayList<Monom> monomList = new ArrayList<Monom>();

    public Polinom(ArrayList<Monom> monomialsList) {
        this.monomList = monomialsList;
    }
    public Polinom()
    {
    }
    public ArrayList<Monom> getMonomialsList() {
        return monomList;
    }

    public void setMonomialsList(ArrayList<Monom> monomialsList) {
        this.monomList = monomialsList;
    }

    public String formatPolinom() {
        String s = "";
        for (Monom m : this.monomList) {
            s = s + m.toString();
        }
        return s;
    }
    //folosit pentru integrare deoarece afisez coeficientul ca si float
    public String formatPolinom2() {
        String s = "";
        for (Monom m : this.monomList) {
            s = s + m.toString2();
        }
        return s;
    }

    public static void polinomSort(Polinom p) {
        int i=0;
      while(i < p.monomList.size() - 1) {
            for (int j = i + 1; j < p.monomList.size(); j++) {
                if (p.monomList.get(i).getDegree() < p.monomList.get(j).getDegree()) {
                    Collections.swap(p.monomList, i, j);
                }
            }
            i++;
        }
    }
    public Polinom addition(Polinom polinom1, Polinom polinom2) {
        Polinom result = new Polinom();
        polinomSort(polinom2);
        polinomSort(polinom1);
        for (Monom m: polinom1.monomList) {
            for (Monom n: polinom2.monomList){
                int p1 = m.getDegree();
                int p2 = n.getDegree();
                if (p1 == p2) {
                    if ((m.getFlag() == 0) && (n.getFlag() == 0))
                    {Monom rezultat=new Monom(0,0);
                        rezultat.coefficient=m.coefficient+n.coefficient;
                        rezultat.degree=m.degree;
                        result.monomList.add(rezultat);
                        m.setFlag(1);
                        n.setFlag(1);
                    }
                }
            }
        }
        for (Monom m: polinom1.monomList)
        { if( m.getFlag() == 0 )
                result.monomList.add(m);
        }

        for (Monom n: polinom2.monomList)
        {if(n.getFlag() == 0 )
                result.monomList.add(n);
        }
        polinomSort(result);
        return result;
    }
    public Polinom substraction(Polinom polinom1, Polinom polinom2) {

        Polinom result = new Polinom();;
        for (Monom n: polinom2.monomList) {
            n.coefficient = n.coefficient * (-1);
        }
        result = result.addition(polinom1, polinom2);
        polinomSort(result);
        return result;
    }

    public Polinom multiplication(Polinom polinom1, Polinom polinom2) {
        Polinom polinomRezultat = new Polinom();
        for (Monom m: polinom1.monomList) {
            for (Monom n: polinom2.monomList) {
                Monom rezultat1 = new Monom(0, 0);
                rezultat1.coefficient = m.coefficient * n.coefficient;
                rezultat1.degree = m.degree + n.degree;
                polinomRezultat.monomList.add(rezultat1);
            }
        }
        polinomSort(polinomRezultat);
        int aux = 0;
        while (aux < polinomRezultat.getMonomialsList().size() - 1) {
            if (polinomRezultat.getMonomialsList().get(aux).getDegree() == polinomRezultat.getMonomialsList().get(aux + 1).getDegree()) {
                polinomRezultat.getMonomialsList().get(aux).coefficient =polinomRezultat.getMonomialsList().get(aux).getCoefficient()
                        + polinomRezultat.getMonomialsList().get(aux + 1).getCoefficient();
                polinomRezultat.getMonomialsList().remove(polinomRezultat.getMonomialsList().get(aux + 1));
            } else {
                aux++;
            }
        }
        return polinomRezultat;
    }
    public Polinom derivation(Polinom polinom)
    { Polinom polinomRezultat = new Polinom();
        for (Monom m: polinom.monomList)
        {
            if(m.getDegree()>=1)
            {  Monom rezultat = new Monom(0, 0);
                rezultat.coefficient=(m.coefficient)*(m.degree);
                rezultat.degree=m.degree-1;
                polinomRezultat.monomList.add(rezultat);
            }
        }
            return polinomRezultat;
    }

    public Polinom integration(Polinom polinom)
    { Polinom polinomRezultat = new Polinom();
        for (Monom m: polinom.monomList)
        {
        Monom rezultat = new Monom(0, 0.0f);
                rezultat.coefficient= (float)((m.coefficient)/(m.degree+1.0f));
                rezultat.degree=m.degree+1;
                polinomRezultat.monomList.add(rezultat);
        }
        return polinomRezultat;
    }
    public String division(Polinom polinom1,Polinom polinom2)
    {   polinomSort(polinom1);
        polinomSort(polinom2);
        int v=0; //un flag
        int j=0; //un index
        Polinom cat=new Polinom();
        while(v==0)
        {
            Monom m=new Monom(0,0);
            m.coefficient=(float)polinom1.monomList.get(j).coefficient/polinom2.monomList.get(0).coefficient;
            m.degree=polinom1.monomList.get(j).degree-polinom2.monomList.get(0).degree;
            cat.monomList.add(m);
            if(m.degree<=0) v=1;
            j=j+1;
            Polinom polinomRezultatAux = new Polinom();
            for (Monom n: polinom2.monomList)
            {
                Monom x=new Monom(0,0);
                x.coefficient=m.coefficient*n.coefficient;
                x.degree=m.degree+n.degree;
                polinomRezultatAux.monomList.add(x);

            }
            Polinom rest=new Polinom();
            rest=rest.substraction(polinom1,polinomRezultatAux);
            polinom1=rest;
        }
        return "  catul: "+ cat.formatPolinom2() + "   restul:  " +polinom1.formatPolinom2();
    }
}
