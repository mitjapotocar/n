
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author aless
 */
class IzjemaManjkajocegaLocila extends RuntimeException {

  public IzjemaManjkajocegaLocila(String izjema) {
    super(izjema);
  }
}

public class Naloga24 {

  public static void dolzineStavkov(String file) throws IzjemaManjkajocegaLocila {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    Scanner sc = null;
    try {
      sc = new Scanner(new File(file));
      int besede = 0;
      while (sc.hasNext()) {
        String item = sc.next();
        besede++;
        if (item.endsWith(".") || item.endsWith("!") || item.endsWith("?")) {
          int val = map.containsKey(besede) ? map.get(besede) + 1 : 1;
          map.put(besede, val);
          besede = 0;
        }
      }
      if (besede != 0) {
        throw new IzjemaManjkajocegaLocila("Izjema manjkajocega locila.");
      }

      for (Integer i : map.keySet()) {
        System.out.println("Stavki dolzine " + i + " se pojavijo: " + map.get(i) + "x.");
      }
    } catch (IOException ioe) {
      System.out.println("Napaka pri branju datoteke.");
    } finally {

      if (sc != null) {
        sc.close();
      }
    }
  }

  public static void main(String[] args) {
    try {
      dolzineStavkov(args[0]);
    } catch (IzjemaManjkajocegaLocila e) {
      System.out.println("Manjka locilo.");
    }
  }

}
