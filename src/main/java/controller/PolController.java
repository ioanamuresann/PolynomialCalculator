package controller;

import view.PolView;
import model.PolPatternMatching;
import model.Polinom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PolController {

    public static void main(String[] args) {
        PolView p = new PolView();
        p.setVisible(true);

        p.addButton(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Polinom p1 = new Polinom();
                Polinom p2 = new Polinom();
                PolPatternMatching pattern = new PolPatternMatching();

                String poli1 = p.firstPoli.getText();
                String poli2 = p.secondPoli.getText();

                p1.monomList = pattern.getMonoms(poli1);
                p2.monomList = pattern.getMonoms(poli2);

                Polinom res=new Polinom();
                res=res.addition(p1,p2);
                System.out.println("Rezultatul adunarii: " + res.formatPolinom());
                p.resultText.setText(res.formatPolinom());
            }
        });

        p.substractionButton(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Polinom p1 = new Polinom();
                Polinom p2 = new Polinom();
                PolPatternMatching pattern = new PolPatternMatching();

                String poli1 = p.firstPoli.getText();
                String poli2 =p.secondPoli.getText();

                p1.monomList = pattern.getMonoms(poli1);
                p2.monomList = pattern.getMonoms(poli2);

                Polinom res= new Polinom();
                res = res.substraction(p1,p2);
                System.out.println("Rezultatul scaderii: " + res.formatPolinom());

                p.resultText.setText(res.formatPolinom());
            }
        });
        p.multiplicationButton(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Polinom p1 = new Polinom();
                Polinom p2 = new Polinom();
                PolPatternMatching pattern = new PolPatternMatching();

                String poli1 = p.firstPoli.getText();
                String poli2 =p.secondPoli.getText();

                p1.monomList = pattern.getMonoms(poli1);
                p2.monomList = pattern.getMonoms(poli2);

                Polinom res=new Polinom();
                res = res.multiplication(p1,p2);
                System.out.println("Rezultatul inmultirii: " + res.formatPolinom());
                p.resultText.setText(res.formatPolinom());
            }
        });
        p.derivateButton(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Polinom p1 = new Polinom();
                PolPatternMatching pattern = new PolPatternMatching();
                String poli1 = p.firstPoli.getText();
                p1.monomList = pattern.getMonoms(poli1);
                Polinom res= new Polinom();
                res=res.derivation(p1);
                System.out.println("Rezultatul derivarii: " + res.formatPolinom());
                p.resultText.setText(res.formatPolinom());
            }
        });
        p.integrationButton(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Polinom p1 = new Polinom();
                PolPatternMatching pattern = new PolPatternMatching();
                String poli1 = p.firstPoli.getText();

                p1.monomList = pattern.getMonoms(poli1);
                Polinom res=new Polinom();
                res=res.integration(p1);
                System.out.println("Rezultatul integrarii: " + res.formatPolinom2());
                p.resultText.setText(res.formatPolinom2());
            }
        });
        p.divisionButton(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Polinom p1 = new Polinom();
                Polinom p2 = new Polinom();
                PolPatternMatching pattern = new PolPatternMatching();

                String poli1 = p.firstPoli.getText();
                String poli2 =p.secondPoli.getText();

                p1.monomList = pattern.getMonoms(poli1);
                p2.monomList = pattern.getMonoms(poli2);
                String x="";
                Polinom res=new Polinom();
               if(p1.monomList.get(0).degree>=p2.monomList.get(0).degree) {
                  x = res.division(p1, p2);
               }
               else  x = res.division(p2, p1);
                System.out.println("Rezultatul impartirii: " +x);

                p.resultText.setText(x);
            }
        });
    }
}
