
import java.io.FileInputStream;

/**
 * V spodnjem programu sta podani dve metodi (preveri in preveri1), ki obe pravilno rešita nalogo.
 * @author Alenka
 */
public class Naloga22 {

  // uporabimo branje treh bajtov naenkrat
  public static boolean preveri(int stevilka, String imeDatoteke) throws Exception {
    FileInputStream is = new FileInputStream(imeDatoteke);
    byte[] vnos = new byte[3];
    while (is.read(vnos) >= 3) {
      int st = (((int) vnos[0] & 0xFF) << 16) | (((int) vnos[1] & 0xFF) << 8) | ((int) vnos[2] & 0xFF);
      if (st == stevilka) {
        is.close();
        return true;
      }
    }
    is.close();
    return false;
  }

  // rešitev z uporabo branja le enega bajta naenkrat (trikrat preberemo za eno številko)
  public static boolean preveri1(int stevilka, String imeDatoteke) throws Exception {
    FileInputStream is = new FileInputStream(imeDatoteke);
    int st;
    while ((st = is.read()) > -1) {
      st = st * 256 * 256 + is.read() * 256 + is.read();
      if (st == stevilka) {
        is.close();
        return true;
      }
    }
    is.close();
    return false;
  }

  public static void main(String[] args) throws Exception {
    //args = new String[] {"5350951", "viri/skrito.dat"};  // je v datoteki
    //args = new String[] {"3973081", "viri/skrito.dat"};  // je v datoteki
    //args = new String[] {"1234567", "viri/skrito.dat"};  // ni v datoteki

    if (args.length != 2) {
      System.out.println("Napačno število argumentov!");
      System.exit(0);
    }

    int stevilka = Integer.parseInt(args[0]);
    System.out.printf("%d %s v datoteki %s\n", stevilka, preveri(stevilka, args[1]) ? "JE" : "NI", args[1]);
  }
}
