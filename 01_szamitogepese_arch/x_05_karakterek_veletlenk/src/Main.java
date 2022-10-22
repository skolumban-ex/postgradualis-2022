import java.util.Random;

public class Main {
    public static void main(String[] args) {

        char c = '(';
        char c2 = 'B';

        String s = "alma";

        int charOsszeg = c + c2;
        System.out.println(charOsszeg);

        char charOsszegMintChar = (char) charOsszeg;
        System.out.println(charOsszegMintChar);

        System.out.println(c - c2);

        System.out.println(c * c2);

        System.out.println(c / c2);

        System.out.println(s + c2);

        //System.out.println(s-c2);

        //System.out.println(s*c2);

        //System.out.println(s/c2);

        Random r = new Random();
        double x1 = r.nextDouble();
        double x2 = r.nextDouble();
        double x3 = r.nextDouble();

        System.out.println(r.nextInt(0, 6));
        System.out.println(r.nextInt(0, 6));
        System.out.println(r.nextInt(0, 6));
        System.out.println(r.nextInt(0, 6));
        System.out.println(r.nextInt(0, 6));
        System.out.println(r.nextInt(0, 6));
        System.out.println(r.nextInt(0, 6));
        System.out.println(r.nextInt(0, 6));

        Math.random();
        // nagy betu generalas
        //A
        char nbA = (char) r.nextInt(65, 91);
        char nbA2 = (char) r.nextInt('A', 'Z' + 1);

        //B
        char nbB = (char) (65 + Math.random() * (91 - 65));

    }
}