/**
 * @author Peter Gabrovšek
 */

public class Naloga21 {
    public static void main(String[] args) {         
        // branje vhodnih argumentov
        int krakov = Integer.parseInt(args[0]);
        int zavojev = Integer.parseInt(args[1]);
        int razmak = Integer.parseInt(args[2]);

        // inicializacija platna
        StdDraw.setCanvasSize(800, 600);
        StdDraw.setXscale(-400, 400);
        StdDraw.setYscale(-300, 300);

        // izris krakov
        for (int i = 0; i < krakov; i++) {
            double x = Math.cos(i * 2 * Math.PI / krakov) * zavojev * razmak;
            double y = Math.sin(i * 2 * Math.PI / krakov) * zavojev * razmak;
            StdDraw.line(0, 0, x, y);
        }

        // izris spirale
        for (int r = 0; r < zavojev; r++) {
            for (int a = 0; a < krakov; a++) {
                double x1 = (r + 1.0 * a / krakov) * Math.cos(a * 2 * Math.PI / krakov) * razmak;
                double y1 = (r + 1.0 * a / krakov) * Math.sin(a * 2 * Math.PI / krakov) * razmak;

                double x2 = (r + 1.0 * (a + 1) / krakov) * Math.cos((a + 1) * 2 * Math.PI / krakov) * razmak;
                double y2 = (r + 1.0 * (a + 1) / krakov) * Math.sin((a + 1) * 2 * Math.PI / krakov) * razmak;

                StdDraw.line(x1, y1, x2, y2);
            }
        }
    }
}
