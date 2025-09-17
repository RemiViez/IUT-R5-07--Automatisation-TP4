import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculetteTest {

    @Test
    public void testAddition() throws Exception {
        Calculette calc = new Calculette();
        calc.ajouterNombre(1.0);
        calc.ajouterNombre(2.0);
        calc.addition();
        assertEquals(3.0, calc.resultat());
    }

    @Test
    public void testSoustraction() throws Exception {
        Calculette calc = new Calculette();
        calc.ajouterNombre(5.0);
        calc.ajouterNombre(3.0);
        calc.soustraction();
        assertEquals(2.0, calc.resultat());
    }

    @Test
    public void testMultiplication() throws Exception {
        Calculette calc = new Calculette();
        calc.ajouterNombre(4.0);
        calc.ajouterNombre(3.0);
        calc.multiplication();
        assertEquals(12.0, calc.resultat());
    }

    @Test
    public void testDivision() throws Exception {
        Calculette calc = new Calculette();
        calc.ajouterNombre(10.0);
        calc.ajouterNombre(2.0);
        calc.division();
        assertEquals(5.0, calc.resultat());
    }

    @Test
    public void testCalculerRPN() throws Exception {
        Calculette calc = new Calculette();
        double res = calc.calculerRPN("1.0 3 + 2 3.2 / +");
        assertEquals(1.0 + 3 + 2 / 3.2, res, 1e-6);
    }

    @Test
    public void testDivisionParZero() {
        Calculette calc = new Calculette();
        calc.ajouterNombre(1.0);
        calc.ajouterNombre(0.0);
        Exception exception = assertThrows(Exception.class, () -> {
            calc.division();
        });
        assertEquals("Division par zéro", exception.getMessage());
    }
}
