import model.PolPatternMatching;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;
import model.Polinom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
public class TestJunit {
    @Test
    public void testAdunare(){
        PolPatternMatching pattern=new PolPatternMatching();
        Polinom p1=new Polinom();
        p1.setMonomialsList(pattern.getMonoms("1x^1-1x^0"));
        Polinom p2=new Polinom();
        p2.setMonomialsList(pattern.getMonoms("5x^4+9x^2"));
        Polinom rezultat=new Polinom();
        rezultat=rezultat.addition(p1,p2);
        System.out.println("Rezultatul adunarii este: " + rezultat.formatPolinom());
        assertEquals(rezultat.formatPolinom(),"+5x^4+9x^2+1x^1-1x^0");
    }
    @Test
    public void testScadere(){
        PolPatternMatching pattern=new PolPatternMatching();
        Polinom p1=new Polinom();
        p1.setMonomialsList(pattern.getMonoms("5x^4+9x^2"));
        Polinom p2=new Polinom();
        p2.setMonomialsList(pattern.getMonoms("-8x^4+2x^3-2x^1"));
        Polinom rezultat=new Polinom();
        rezultat=rezultat.substraction(p1,p2);
        System.out.println("Rezultatul scaderii este: " + rezultat.formatPolinom());
        assertEquals(rezultat.formatPolinom(),"+13x^4-2x^3+9x^2+2x^1");

    }
    @Test
    public void testInmultire(){
        PolPatternMatching pattern=new PolPatternMatching();
        Polinom p1=new Polinom();
        p1.setMonomialsList(pattern.getMonoms("3x^2-1x^1+1x^0"));
        Polinom p2=new Polinom();
        p2.setMonomialsList(pattern.getMonoms("1x^1-2x^0"));
        Polinom rezultat=new Polinom();
        rezultat=rezultat.multiplication(p1,p2);
        System.out.println("Rezultatul inmultirii este: " + rezultat.formatPolinom());
        assertEquals(rezultat.formatPolinom(),"+3x^3-7x^2+3x^1-2x^0");
    }
    @Test
    public void testImpartire(){
        PolPatternMatching pattern=new PolPatternMatching();
        Polinom p1=new Polinom();
        p1.setMonomialsList(pattern.getMonoms("3x^2-1x^1+1x^0"));
        Polinom p2=new Polinom();
        p2.setMonomialsList(pattern.getMonoms("1x^1-2x^0"));
        Polinom rezultat=new Polinom();
        String rez=rezultat.division(p1,p2);
        System.out.println("Rezultatul impartirii este: " + rez);
        assertNotNull(rez);
    }
    @Test
    public void testDerivare(){
        PolPatternMatching pattern=new PolPatternMatching();
        Polinom p1=new Polinom();
        p1.setMonomialsList(pattern.getMonoms("3x^2-1x^1+1x^0"));
        Polinom rezultat=new Polinom();
        rezultat=rezultat.derivation(p1);
        System.out.println("Rezultatul derivarii este: " + rezultat.formatPolinom());
        assertEquals(rezultat.formatPolinom(),"+6x^1-1x^0");
    }
    @Test
    public void testIntegrare(){
        PolPatternMatching pattern=new PolPatternMatching();
        Polinom p1=new Polinom();
        p1.setMonomialsList(pattern.getMonoms("+3x^2-1x^1+1x^0"));
        Polinom rezultat=new Polinom();
        rezultat=rezultat.integration(p1);
        System.out.println("Rezultatul integrarii este: " + rezultat.formatPolinom());
        assertEquals(rezultat.formatPolinom(),"+1x^30x^2+1x^1");
    }
}
