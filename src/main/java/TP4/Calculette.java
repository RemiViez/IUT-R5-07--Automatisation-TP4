import java.util.Stack;

public class Calculette {
    private Stack<Double> pile = new Stack<>();

    public void ajouterNombre(double nombre) {
        pile.push(nombre);
    }

    public void addition() throws Exception {
        if (pile.size() < 2) throw new Exception("Pas assez d'opérandes");
        double b = pile.pop();
        double a = pile.pop();
        pile.push(a + b);
    }

    public void soustraction() throws Exception {
        if (pile.size() < 2) throw new Exception("Pas assez d'opérandes");
        double b = pile.pop();
        double a = pile.pop();
        pile.push(a - b);
    }

    public void multiplication() throws Exception {
        if (pile.size() < 2) throw new Exception("Pas assez d'opérandes");
        double b = pile.pop();
        double a = pile.pop();
        pile.push(a * b);
    }

    public void division() throws Exception {
        if (pile.size() < 2) throw new Exception("Pas assez d'opérandes");
        double b = pile.pop();
        if (b == 0) throw new Exception("Division par zéro");
        double a = pile.pop();
        pile.push(a / b);
    }

    public double resultat() throws Exception {
        if (pile.size() != 1) throw new Exception("Expression invalide");
        return pile.pop();
    }

    public double calculerRPN(String expression) throws Exception {
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            switch (token) {
                case "+":
                    addition();
                    break;
                case "-":
                    soustraction();
                    break;
                case "*":
                    multiplication();
                    break;
                case "/":
                    division();
                    break;
                default:
                    ajouterNombre(Double.parseDouble(token));
                    break;
            }
        }
        return resultat();
    }
}
