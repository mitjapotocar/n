
import java.util.ArrayList;

/**
 *
 * @author Alenka
 */
public class Naloga23 {

    public static void main(String[] args) {
        ArrayList<Tocka> tocke = new ArrayList();
        tocke.add(new Tocka(5, 8));
        tocke.add(new Tocka(3, 4));
        tocke.add(new Tocka(3, 2));
        tocke.add(new Tocka(1, 5));
        tocke.add(new Tocka(11, -4));

        ArrayList<Lik> liki = new ArrayList();
        liki.add(new Krog(new Tocka(3, 5), 6));
        liki.add(new Pravokotnik(new Tocka(1, 2), 5, 7));
        liki.add(new Krog(new Tocka(0, 0), 5));
        liki.add(new Pravokotnik(new Tocka(-1, 0), 1, 1));        
        for (Lik l : liki) {
            for (Tocka t : tocke) {
                // System.out.printf("%s %s znotraj lika %s.\n", t.toString(), l.jeZnotraj(t) ? "je" : "ni", l.toString());
                System.out.printf("%s ", l.jeZnotraj(t) ? "je" : "ni");
            }
        }
    }
}

class Tocka {

    private int x, y;

    public Tocka(int a, int b) {
        this.x = a;
        this.y = b;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("Tocka(%d, %d)", this.x, this.y);
    }
}

abstract class Lik {

    public abstract boolean jeZnotraj(Tocka t);
}

class Pravokotnik extends Lik {

    private Tocka oglisce; // spodaj levo
    private int sirina;
    private int visina;

    public Pravokotnik(Tocka o, int s, int v) {
        this.oglisce = o;
        this.sirina = s;
        this.visina = v;
    }

    @Override
    public boolean jeZnotraj(Tocka t) {
        return (t.getX() >= oglisce.getX()) && (t.getX() <= (oglisce.getX() + sirina)) && (t.getY() >= oglisce.getY()) && (t.getY() <= (oglisce.getY() + visina));
    }

    @Override
    public String toString() {
        return String.format("Pravokotnik(%s, %d, %d)", oglisce.toString(), this.sirina, this.visina);
    }
}

class Krog extends Lik {

    private Tocka sredisce;
    private int radij;

    public Krog(Tocka s, int r) {
        this.sredisce = s;
        this.radij = r;
    }

    @Override
    public boolean jeZnotraj(Tocka t) {
        return ((t.getX() - sredisce.getX()) * (t.getX() - sredisce.getX()) + (t.getY() - sredisce.getY()) * (t.getY() - sredisce.getY())) <= radij * radij;
    }

    @Override
    public String toString() {
        return String.format("Krog(%s, %d)", sredisce.toString(), this.radij);
    }
}
