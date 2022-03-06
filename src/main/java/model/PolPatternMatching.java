package model;

import model.Monom;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolPatternMatching {
    public PolPatternMatching() {
    }

    private int getExp(String m) {
        String[] aux = m.split("\\^"); //ia tot ce e dupa ^
        int exponent;
        exponent = Integer.parseInt(aux[1]);
        return exponent;
    }

    private int getCoeff(String m) {
        String[] aux = m.split("x");  //ia tot ce e inainte de x
        int coeficient;
        coeficient =Integer.parseInt(aux[0]);
        return coeficient;
    }
public ArrayList<Monom> getMonoms(String polynom) {
    ArrayList<Monom> poly = new ArrayList<Monom>();
    Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
    Matcher matcher = pattern.matcher(polynom);
    int x = 0;
    while (matcher.find()) {
        x = x + 1;
        poly.add(new Monom(getExp(matcher.group(1)),getCoeff(matcher.group(1))));
    }
    return poly;
}
}